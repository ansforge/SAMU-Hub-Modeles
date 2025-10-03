# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots[
    "TestSnapshotV1V2Converter::test_exhaustive_snapshot_V1_to_V2_upgrade 1"
] = """{
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
            "resourcesRequest": {
              "request": {
                "requestId": "fr.health.samu770.request.as41pb",
                "datetime": "2024-01-04T08:30:00+01:00",
                "convention": "HORS",
                "purpose": "TIH",
                "deadline": "12H",
                "freetext": "Besoin de l\\u2019h\\u00e9liSMUR 91 pour transfert en chirurgie sp\\u00e9cialis\\u00e9e de la main \\u00e0 Nogent. "
              },
              "caseId": "fr.health.samu770.DRFR157702400400055",
              "status": "ANNULEE"
            }
          }
        }
      }
    }
  ]
}"""

snapshots[
    "TestSnapshotV1V2Converter::test_exhaustive_snapshot_V2_to_V1_upgrade 1"
] = """{
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
            "resourcesRequest": {
              "request": {
                "requestId": "fr.health.samu76A.request.af78b21",
                "datetime": "2024-08-01T16:44:00+02:00",
                "freetext": "Besoin d\\u2019une \\u00e9quipe SMUR p\\u00e9diatrique suppl\\u00e9mentaire, pour prise en charge 2 enfants, dont 1 possible h\\u00e9morragie interne. ",
                "purpose": "SMUR",
                "deadline": "DEL12H",
                "convention": "HORS"
              },
              "caseId": "fr.health.samu800.DRFR158002421400215",
              "status": "ANNULEE"
            }
          }
        }
      }
    }
  ]
}"""

snapshots[
    "TestSnapshotV1V2Converter::test_required_fields_snapshot_V1_to_V2_upgrade 1"
] = """{
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
            "resourcesRequest": {
              "request": {
                "requestId": "fr.health.samu770.request.as41pb",
                "datetime": "2024-01-04T08:30:00+01:00",
                "purpose": "PARAMED"
              },
              "caseId": "fr.health.samu770.DRFR157702400400055"
            }
          }
        }
      }
    }
  ]
}"""
