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
            "resourcesResponse": {
              "caseId": "fr.health.samu950.DRFR159502401800159",
              "response": {
                "datetime": "2024-01-18T18:22:00+01:00",
                "answer": "DIFFEREE",
                "freetext": "Ok pour kit p\\u00e9diatrique. D\\u00e9part imm\\u00e9diat.",
                "deadline": "DEL0"
              },
              "requestId": "fr.health.samu950.request.zs498qo"
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
            "resourcesResponse": {
              "response": {
                "answer": "PARTIELLE",
                "datetime": "2024-08-01T16:45:00+02:00",
                "deadline": "RDV",
                "freetext": "Ok pour envoi H\\u00e9liSMUR. Engagement possible dans 10min seulement."
              },
              "caseId": "fr.health.samu800.DRFR158002421400215",
              "requestId": "fr.health.samu76A.request.af78b21"
            }
          }
        }
      }
    }
  ]
}"""

snapshots[
    "TestSnapshotV1V2Converter::test_exhaustive_snapshot_V2_to_V3_upgrade 1"
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
            "resourcesResponse": {
              "response": {
                "answer": "PARTIELLE",
                "datetime": "2024-08-01T16:45:00+02:00",
                "deadline": "RDV",
                "freetext": "Ok pour envoi H\\u00e9liSMUR. Engagement possible dans 10min seulement."
              },
              "caseId": "fr.health.samu800.DRFR158002421400215",
              "requestId": "fr.health.samu76A.request.af78b21"
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
            "resourcesResponse": {
              "response": {
                "answer": "REFUSEE",
                "datetime": "2024-08-01T16:45:00+02:00"
              },
              "caseId": "fr.health.samu800.DRFR158002421400215",
              "requestId": "fr.health.samu76A.request.af78b21"
            }
          }
        }
      }
    }
  ]
}"""

snapshots[
    "TestSnapshotV1V2Converter::test_required_fields_snapshot_V2_to_V3_upgrade 1"
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
            "resourcesResponse": {
              "response": {
                "answer": "ACCEPTEE",
                "datetime": "2024-08-01T16:45:00+02:00"
              },
              "caseId": "fr.health.samu800.DRFR158002421400215",
              "requestId": "fr.health.samu76A.request.af78b21"
            }
          }
        }
      }
    }
  ]
}"""
