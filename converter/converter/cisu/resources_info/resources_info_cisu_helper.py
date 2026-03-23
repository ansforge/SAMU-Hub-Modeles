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
        resources = rs_ri["content"]["jsonContent"]["embeddedJsonContent"]["message"][
            "resourcesInfo"
        ]["resource"]
    except KeyError:
        return None

    resource_state_by_id: dict[str, dict] = {}

    for rs_sr in rs_sr_list:
        try:
            resource_status = rs_sr["content"]["jsonContent"]["embeddedJsonContent"][
                "message"
            ]["resourceStatus"]
            resource_id = resource_status["resourceId"]
            resource_state_by_id[resource_id] = resource_status["state"]
        except KeyError:
            continue

    # we override each resource.state of RS-RI with state from latest RS-SR, except if missing -> in this case we return nothing
    for resource in resources:
        resource_id = resource.get("resourceId")

        if not resource_id or resource_id not in resource_state_by_id:
            return None

        # state is an array in RS-RI
        resource["state"] = [resource_state_by_id[resource_id]]

    # transform RS-RI to RC-RI
    return ResourcesInfoCISUConverter.from_rs_to_cisu(rs_ri)
