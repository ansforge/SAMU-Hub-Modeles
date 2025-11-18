# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots[
    "TestSnapshotReferenceConverter::test_exhaustive_snapshot_cisu_to_rs 1"
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
            "reference": {
              "distributionID": "fr.health.samuB_2607723d-507d-4cbf-bf74-12345f7064cd",
              "refused": false,
              "errorDistributionID": "2607723d-507d-4cbf-bf74-12345f7064cd",
              "step": "ERREUR"
            }
          }
        }
      }
    }
  ]
}"""

snapshots[
    "TestSnapshotReferenceConverter::test_exhaustive_snapshot_rs_to_cisu 1"
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
            "reference": {
              "distributionID": "fr.health.samuB_2607723d-507d-4cbf-bf74-12345f7064cd",
              "refused": false,
              "errorDistributionID": "2607723d-507d-4cbf-bf74-12345f7064cd",
              "step": "ERREUR"
            }
          }
        }
      }
    }
  ]
}"""
