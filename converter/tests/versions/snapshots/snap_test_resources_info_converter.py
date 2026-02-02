# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots['TestSnapshotV1V2Converter::test_missing_vehicle_type_snapshot_V1_to_V2_upgrade 1'] = '''{
  "distributionID": "fr.health.samuA_2608323d-507d-4cbf-bf74-52007f8124ea",
  "senderID": "fr.health.samuA",
  "dateTimeSent": "2022-09-27T08:23:34+02:00",
  "dateTimeExpires": "2072-09-27T08:23:34+02:00",
  "distributionStatus": "Actual",
  "distributionKind": "Report",
  "descriptor": {
    "language": "fr-FR",
    "explicitAddress": {
      "explicitAddressScheme": "hubex",
      "explicitAddressValue": "fr.health.samuB"
    }
  },
  "content": [
    {
      "jsonContent": {
        "embeddedJsonContent": {
          "message": {
            "messageId": "2608323d-507d-4cbf-bf74-52007f8124ea",
            "sender": {
              "name": "samuA",
              "URI": "hubsante:fr.health.samuA"
            },
            "sentAt": "2022-09-27T08:23:34+02:00",
            "status": "Actual",
            "kind": "Report",
            "recipient": [
              {
                "name": "samuB",
                "URI": "hubsante:fr.health.samuB"
              }
            ],
            "resourcesInfo": {
              "caseId": "fr.health.samu770.DRFR157702421400215",
              "resource": [
                {
                  "datetime": "2024-08-01T16:55:00+02:00",
                  "resourceId": "fr.health.samu770.resource.VLM250",
                  "team": {
                    "medicalLevel": "MED"
                  },
                  "state": [
                    {
                      "datetime": "2024-08-06T16:45:00+02:00",
                      "status": "ENGAGE"
                    }
                  ],
                  "vehicleType": "AUTREVEC.AUTRE"
                }
              ]
            }
          }
        }
      }
    }
  ]
}'''
