from converter.cisu.resources_info.resources_info_cisu_helper import (
    enrich_rs_ri_with_rs_srs,
)


def _wrap_edxl(
    use_case: dict, message_type: str, distribution_id: str = "dist-test"
) -> dict:
    """Wrap a use-case dict in a minimal EDXL envelope."""
    return {
        "distributionID": distribution_id,
        "content": [
            {
                "jsonContent": {
                    "embeddedJsonContent": {"message": {message_type: use_case}}
                }
            }
        ],
    }


def _make_rs_ri_edxl(resources: list[dict], distribution_id: str = "dist-ri") -> dict:
    """Wrap a resource list in a minimal RS-RI EDXL envelope."""

    return _wrap_edxl({"resource": resources}, "resourcesInfo", distribution_id)


def _make_rs_sr_edxl(use_case: dict, distribution_id: str = "dist-sr") -> dict:
    """Wrap an RS-SR use-case in a minimal EDXL envelope."""
    return _wrap_edxl(use_case, "resourcesStatus", distribution_id)


def test_no_persisted_rs_sr():
    """
    Si, pour une ressource dans le RS-RI original (avec un status ou non)
    on ne trouve pas de status dans un RS-SR persisté
    ne pas modifier la ressource originale.
    """

    rs_ri_edxl = _make_rs_ri_edxl(
        [
            {"resourceId": "r1"},
            {"resourceId": "r2"},
        ]
    )

    result = enrich_rs_ri_with_rs_srs(rs_ri_edxl, [])

    assert result is not None
    assert result["resource"][0] == {"resourceId": "r1"}
    assert result["resource"][1] == {"resourceId": "r2"}


def test_no_current_state_but_persisted_rs_sr():
    """
    Si, pour une ressource dans le RS-RI original
    on trouve un RS-SR persisté, et que la ressource originale n'a pas de status
    remplacer le status de la ressource original par celui de la ressource persistée
    """

    rs_ri_edxl = _make_rs_ri_edxl(
        [
            {"resourceId": "r1"},
            {"resourceId": "r2"},
        ]
    )

    rs_sr_edxl_list = [
        _make_rs_sr_edxl({"resourceId": "r1", "state": {"status": "OK"}}, "dist-sr-1"),
        _make_rs_sr_edxl({"resourceId": "r2", "state": {"status": "KO"}}, "dist-sr-2"),
    ]

    result = enrich_rs_ri_with_rs_srs(rs_ri_edxl, rs_sr_edxl_list)

    assert result is not None
    assert result["resource"][0]["state"] == [{"status": "OK"}]
    assert result["resource"][1]["state"] == [{"status": "KO"}]


def test_current_state_and_persisted_rs_sr():
    """
    Si, pour une ressource dans le RS-RI original, on trouve un RS-SR persisté
    et que la ressource originale a un status
    remplacer le status de la ressource original par le status le plus récent en se basant sur le champ datetime contenu dans le status.
    """

    rs_ri_edxl = _make_rs_ri_edxl(
        [
            {
                "resourceId": "r1",
                "state": [
                    {"status": "PENDING", "datetime": "2025-05-18T18:00:00+02:00"}
                ],
            },
            {
                "resourceId": "r2",
                "state": [{"status": "DONE", "datetime": "2025-05-18T19:00:00+02:00"}],
            },
        ]
    )

    rs_sr_edxl_list = [
        _make_rs_sr_edxl(
            {
                "resourceId": "r1",
                "state": {
                    "status": "PENDING2",
                    "datetime": "2025-05-18T17:00:00+02:00",
                },
            },
            "dist-sr-1",
        ),
        _make_rs_sr_edxl(
            {
                "resourceId": "r2",
                "state": {"status": "DONE2", "datetime": "2025-05-18T20:00:00+02:00"},
            },
            "dist-sr-2",
        ),
    ]

    result = enrich_rs_ri_with_rs_srs(rs_ri_edxl, rs_sr_edxl_list)

    assert result is not None
    assert result["resource"][0]["state"][0]["status"] == "PENDING"
    assert result["resource"][1]["state"][0]["status"] == "DONE2"
