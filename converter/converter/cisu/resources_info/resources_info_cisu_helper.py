from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)


def merge_info_and_resources(
    rs_ri: dict,
    rs_sr_list: list[dict],
) -> dict | None:
    """
    Enrichit un RS-RI avec les états provenant des RS-SR.

    Retourne :
        - RC-RI enrichi si toutes les ressources ont un état
        - None sinon
    """

    try:
        resources = rs_ri["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "resourcesInfo"
        ]["resource"]
    except KeyError:
        return None

    resource_state_by_id: dict[str, dict] = {}

    for rs_sr in rs_sr_list:
        try:
            resource_status = rs_sr["content"][0]["jsonContent"]["embeddedJsonContent"][
                "message"
            ]["resourceStatus"]
            resource_id = resource_status["resourceId"]
            resource_state_by_id[resource_id] = resource_status["state"]
        except KeyError:
            continue

    # we override each resource.state of RS-RI with state from latest RS-SR, except if missing -> in this case we return nothing
    for resource in resources:
        resource_id = resource.get("resourceId")
        rs_sr_state = resource_state_by_id.get(resource_id)

        # resource has no state in RS-RI and no RS-SR has been emitted yet
        if "state" not in resource and rs_sr_state is None:
            return None

        # a RS-SR has been emitted, we set the RS-RI resource state or override it if present
        if rs_sr_state is not None:
            resource["state"] = [rs_sr_state]

    # transform RS-RI to RC-RI
    return ResourcesInfoCISUConverter.from_rs_to_cisu(rs_ri)
