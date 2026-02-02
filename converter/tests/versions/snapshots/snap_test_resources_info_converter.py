# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots['TestSnapshotV1V2Converter::test_exhaustive_snapshot_V1_to_V2_upgrade 1'] = '''{
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
              "caseId": "fr.health.samu800.DRFR158002421400215",
              "resource": [
                {
                  "contact": {
                    "details": "712318965",
                    "type": "FAX"
                  },
                  "team": {
                    "name": "Equipe Buse1",
                    "medicalLevel": "MED"
                  },
                  "state": [
                    {
                      "datetime": "2024-08-06T16:45:00+02:00",
                      "status": "TRANSP"
                    },
                    {
                      "datetime": "2024-08-06T16:55:00+02:00",
                      "status": "ARRIVEE",
                      "availability": true
                    }
                  ],
                  "datetime": "2024-08-01T16:55:00+02:00",
                  "requestId": "fr.health.samu76A.request.af78b21",
                  "resourceId": "fr.health.samu800.resource.Heli80bec6",
                  "missionId": "fr.health.samu800.mission.af78b21",
                  "centerName": "Centre SMUR 800",
                  "centerCity": "80000",
                  "orgId": "fr.health.samu800",
                  "name": "HELISMUR 80 - BEC6",
                  "freetext": [
                    "Premier commentaire",
                    "Deuxi\\u00e8me commentaire",
                    "Immatriculation : BCE6"
                  ],
                  "vehicleType": "LIB"
                },
                {
                  "datetime": "2024-08-01T16:55:00+02:00",
                  "resourceId": "fr.health.samu800.resource.Heli80bec6",
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

snapshots['TestSnapshotV1V2Converter::test_required_fields_snapshot_V1_to_V2_upgrade 1'] = '''{
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
              "caseId": "fr.health.samu800.DRFR158002421400215",
              "resource": [
                {
                  "datetime": "2024-08-01T16:55:00+02:00",
                  "resourceId": "fr.health.samu800.resource.Heli80bec6",
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

snapshots['TestSnapshotV2V1Converter::test_exhaustive_snapshot_V2_to_V1_upgrade 1'] = '''{
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
              "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8",
              "mobilizedResource": [
                {
                  "team": {
                    "name": "Equipe SMUR 4",
                    "teamCare": "PARAMED"
                  },
                  "name": "VLM4",
                  "datetime": "2024-05-26T13:22:00+02:00",
                  "resourceId": "fr.health.samu440.resource.VLM4",
                  "orgId": "fr.health.samu440",
                  "requestId": "fr.health.samu440.request.123",
                  "missionId": "fr.health.samu440.mission.123",
                  "centerName": "Centre SMUR 440",
                  "centerCity": "44000",
                  "state": [
                    {
                      "status": "TRANSP2",
                      "datetime": "2024-05-26T13:22:00+02:00",
                      "availability": false
                    },
                    {
                      "datetime": "2024-05-26T13:20:00+02:00",
                      "status": "FINPEC"
                    }
                  ],
                  "contact": {
                    "details": "+33645987297",
                    "type": "TEL"
                  },
                  "freetext": [
                    "Premier commentaire",
                    "Deuxi\\u00e8me commentaire"
                  ],
                  "vehiculeType": "VPL",
                  "resourceType": "AUTRE"
                },
                {
                  "resourcesInfo": {
                    "resource": [
                      {
                        "datetime": "2024-05-26T13:22:00+02:00",
                        "resourceId": "fr.health.samu440.resource.VLM4",
                        "vehicleType": "AASC.VLSC"
                      }
                    ],
                    "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8"
                  },
                  "resourceType": "AUTRE"
                }
              ]
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotV2V1Converter::test_required_fields_snapshot_V2_to_V1_upgrade 1'] = '''{
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
              "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8",
              "mobilizedResource": [
                {
                  "datetime": "2024-05-26T13:22:00+02:00",
                  "resourceId": "fr.health.samu440.resource.VLM4",
                  "vehiculeType": "TAXI",
                  "resourceType": "AUTRE"
                }
              ]
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotV2V3Converter::test_exhaustive_snapshot_V2_to_V3_upgrade 1'] = '''{
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
              "resource": [
                {
                  "team": {
                    "medicalLevel": "PARAMED",
                    "name": "Equipe SMUR 4"
                  },
                  "vehicleType": "SIS.VPL",
                  "name": "VLM4",
                  "datetime": "2024-05-26T13:22:00+02:00",
                  "resourceId": "fr.health.samu440.resource.VLM4",
                  "orgId": "fr.health.samu440",
                  "requestId": "fr.health.samu440.request.123",
                  "missionId": "fr.health.samu440.mission.123",
                  "centerName": "Centre SMUR 440",
                  "centerCity": "44000",
                  "state": [
                    {
                      "status": "TRANSP2",
                      "datetime": "2024-05-26T13:22:00+02:00",
                      "availability": false
                    },
                    {
                      "datetime": "2024-05-26T13:20:00+02:00",
                      "status": "FINPEC"
                    }
                  ],
                  "contact": {
                    "details": "+33645987297",
                    "type": "TEL"
                  },
                  "freetext": [
                    "Premier commentaire",
                    "Deuxi\\u00e8me commentaire"
                  ]
                },
                {
                  "resourcesInfo": {
                    "resource": [
                      {
                        "datetime": "2024-05-26T13:22:00+02:00",
                        "resourceId": "fr.health.samu440.resource.VLM4",
                        "vehicleType": "AASC.VLSC"
                      }
                    ],
                    "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8"
                  }
                }
              ],
              "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotV2V3Converter::test_exhaustive_snapshot_V3_to_V2_upgrade 1'] = '''{
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
              "resource": [
                {
                  "contact": {
                    "details": "FM5678",
                    "type": "RADIO"
                  },
                  "team": {
                    "medicalLevel": "SECOURS",
                    "name": "Equipe SMUR 5"
                  },
                  "state": [
                    {
                      "datetime": "2024-08-01T16:42:00+02:00",
                      "status": "FINMED"
                    },
                    {
                      "datetime": "2024-08-01T16:42:00+02:00",
                      "status": "RET-BASE",
                      "availability": true
                    }
                  ],
                  "datetime": "2024-08-01T16:42:00+02:00",
                  "resourceId": "fr.health.samu76A.resource.VLM12",
                  "orgId": "fr.health.samu76A",
                  "vehicleType": "SMUR.VLM",
                  "name": "VLM 76 - A45",
                  "freetext": [
                    "Patient ID : fr.fire.sis076.cgo-076.patient.179"
                  ]
                },
                {
                  "contact": {
                    "details": "+33645987297",
                    "type": "TEL"
                  },
                  "team": {
                    "name": "Equipe Rouge",
                    "medicalLevel": "SECOURS"
                  },
                  "state": [
                    {
                      "datetime": "2024-08-01T16:40:00+02:00",
                      "status": "FINMED",
                      "availability": false
                    }
                  ],
                  "datetime": "2024-08-01T16:40:00+02:00",
                  "resourceId": "fr.fire.sis076.cgo-076.resource.VSAV3A",
                  "requestId": "fr.fire.sis076.cgo-076.request.177",
                  "centerName": "Centre de Secours 76 - A",
                  "missionId": "fr.fire.sis076.cgo-076.mission.177",
                  "centerCity": "75011",
                  "orgId": "fr.fire.sdis76.cgo-076",
                  "name": "VSAV 76 - 22D8",
                  "vehicleType": "LIB.AUTREPRO",
                  "freetext": [
                    "commentaire",
                    "autre commentaire",
                    "Patient ID : fr.fire.sis076.cgo-076.patient.177"
                  ]
                }
              ],
              "caseId": "fr.health.samu800.DRFR158002421400215"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotV2V3Converter::test_required_fields_snapshot_V2_to_V3_upgrade 1'] = '''{
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
              "resource": [
                {
                  "datetime": "2024-05-26T13:22:00+02:00",
                  "resourceId": "fr.health.samu440.resource.VLM4",
                  "vehicleType": "AUTREVEC.TAXI"
                }
              ],
              "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotV2V3Converter::test_required_fields_snapshot_V3_to_V2_upgrade 1'] = '''{
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
              "resource": [
                {
                  "datetime": "2024-08-01T16:40:00+02:00",
                  "resourceId": "fr.fire.sis076.cgo-076.resource.VSAV3A",
                  "vehicleType": "LIB.AUTREPRO"
                }
              ],
              "caseId": "fr.health.samu800.DRFR158002421400215"
            }
          }
        }
      }
    }
  ]
}'''
