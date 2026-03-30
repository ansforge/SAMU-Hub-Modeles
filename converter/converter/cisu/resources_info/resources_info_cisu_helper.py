def merge_info_and_resources(
    resources: list[dict],
    resources_status_list: list[dict],
) -> list[dict]:
    """
    Enrichit une liste de resources avec les états provenant des resources_status.

    Args:
        resources: liste de resources (issues du RS-RI déjà extraites)
        resources_status_list: liste de resourceStatus (issues des RS-SR déjà extraites)

    Returns:
        - resources enrichies si un resource_status a été trouvé ; resource inchangée dans le cas contraire
    """

    resource_state_by_resource_id: dict[str, dict] = {}

    for resource_status in resources_status_list:
        resource_id = resource_status.get("resourceId")
        state = resource_status.get("state")

        if resource_id is not None and state is not None:
            resource_state_by_resource_id[resource_id] = state

    for resource in resources:
        resource_id = resource.get("resourceId")
        if isinstance(resource_id, str):
            rs_sr_state = resource_state_by_resource_id.get(resource_id)
        else:
            rs_sr_state = None

        # override or set state from RS-SR
        if rs_sr_state is not None:
            resource["state"] = [
                rs_sr_state
            ]  # we override the RS-RI state array by a single array with last state only

    return resources
