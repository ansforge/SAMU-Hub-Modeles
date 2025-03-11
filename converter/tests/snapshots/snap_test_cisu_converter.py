# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots['TestSnapshotCisuConverter::test_snapshot_RC_EDA_exhaustive_bis_message 1'] = '''{
  "distributionID": "fr.fire.sdisZ_2608323d-507d-4cbf-bf74-52007f8124ea",
  "senderID": "fr.fire.sdisZ",
  "dateTimeSent": "2022-09-27T08:23:34+02:00",
  "dateTimeExpires": "2072-09-27T08:23:34+02:00",
  "distributionStatus": "Actual",
  "distributionKind": "Report",
  "descriptor": {
    "language": "fr-FR",
    "explicitAddress": {
      "explicitAddressScheme": "hubex",
      "explicitAddressValue": "fr.health.samuA"
    }
  },
  "content": [
    {
      "jsonContent": {
        "embeddedJsonContent": {
          "message": {
            "messageId": "2608323d-507d-4cbf-bf74-52007f8124ea",
            "sender": {
              "name": "sdisZ",
              "URI": "hubsante:fr.fire.sdisZ"
            },
            "sentAt": "2022-09-27T08:23:34+02:00",
            "status": "Actual",
            "kind": "Report",
            "recipient": [
              {
                "name": "samuA",
                "URI": "hubsante:fr.health.samuA"
              }
            ],
            "createCaseHealth": {
              "caseId": "fr.health.samu440.DRFR154402413800862",
              "senderCaseId": "DRFR154402413800862",
              "creation": "2024-05-26T13:15:00+02:00",
              "qualification": {
                "whatsHappen": {
                  "code": "C02.05.02",
                  "label": "Obst\\u00e9trique"
                },
                "healthMotive": {
                  "code": "M03.02",
                  "label": "Autre probl\\u00e8me obst\\u00e9trique non h\\u00e9morragique"
                },
                "locationKind": {
                  "code": "L04.02.00",
                  "label": "Centre commercial / magasin"
                },
                "riskThreat": [
                  {
                    "label": "Implication d\\u2019une personnalit\\u00e9",
                    "code": "R25"
                  }
                ],
                "details": {
                  "priority": "P0"
                }
              },
              "location": {
                "name": "Centre Commercial Atlantis",
                "detailedAddress": {
                  "complete": "4, Boulevard Salvador Allende",
                  "number": "4",
                  "wayName": {
                    "complete": "Boulevard Salvador Allende",
                    "type": "Boulevard",
                    "name": "Salvador Allende"
                  }
                },
                "city": {
                  "name": "Saint-Herblain",
                  "inseeCode": "44162"
                },
                "access": {
                  "floor": "RDC",
                  "buildingName": "Soleil",
                  "entrance": "B",
                  "roomNumber": "B",
                  "interphone": "Dubois",
                  "accessCode": [
                    "1234A"
                  ],
                  "elevator": "B"
                },
                "externalLocationId": [
                  {
                    "source": "SIRET",
                    "value": "70142121200018"
                  }
                ],
                "geometry": {
                  "point": {
                    "coord": {
                      "lon": -1.6318399,
                      "lat": 47.2224055,
                      "precision": "EXACTE"
                    }
                  },
                  "datetime": "2024-05-26T11:16:00+02:00"
                },
                "externalInfo": [
                  {
                    "freetext": "BAN",
                    "type": "PHOTO",
                    "uri": "AZ1234"
                  }
                ],
                "freetext": "Magasin bleu et jaune\\nD\\u00e9tails de commune : Saint-Marthe"
              },
              "initialAlert": {
                "reception": "2024-05-26T13:15:00+02:00",
                "caller": {
                  "callerContact": {
                    "type": "TEL",
                    "detail": "+33671832618",
                    "channel": "PERSONNE"
                  },
                  "callbackContact": {
                    "type": "TEL",
                    "detail": "+33671832618",
                    "channel": "PERSONNE"
                  },
                  "detailedName": {
                    "complete": "Agn\\u00e8s Duberti",
                    "lastName": "Duberti",
                    "firstName": "Agn\\u00e8s"
                  },
                  "type": "TIERS",
                  "communication": "AUCUNE",
                  "language": "fr",
                  "freetext": "Coll\\u00e8gue de travail de la victime"
                },
                "notes": [
                  {
                    "freetext": "count: \'1\'\\nfreetext: Femme enceinte de 2 mois qui est tomb\\u00e9 d\'une \\u00e9chelle au bureau. Delphine\\n  Vigneau, 32 ans.\\nmainVictim: ADULTE\\n; - URI: https://hub.esante.gouv.fr/\\n  description: PHOTO\\n; calltakerContact:\\n  channel: PERSONNE\\n  detail: \'+33162863746\'\\n  type: TEL\\ncalltakerId: ARM1234\\ncontrolRoom: CRRA44\\norganization: fr.health.samu440\\nrole: ARM\\n; - Mari m\\u00e9decin\\n"
                  }
                ]
              },
              "additionalInformation": {
                "customMap": [
                  {
                    "key": "COMMERCIAL",
                    "value": "IKEA Nantes"
                  }
                ]
              },
              "owner": "fr.health.samuA"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotCisuConverter::test_snapshot_RC_EDA_exhaustive_message 1'] = '''{
  "distributionID": "fr.fire.sdisZ_2608323d-507d-4cbf-bf74-52007f8124ea",
  "senderID": "fr.fire.sdisZ",
  "dateTimeSent": "2022-09-27T08:23:34+02:00",
  "dateTimeExpires": "2072-09-27T08:23:34+02:00",
  "distributionStatus": "Actual",
  "distributionKind": "Report",
  "descriptor": {
    "language": "fr-FR",
    "explicitAddress": {
      "explicitAddressScheme": "hubex",
      "explicitAddressValue": "fr.health.samuA"
    }
  },
  "content": [
    {
      "jsonContent": {
        "embeddedJsonContent": {
          "message": {
            "messageId": "2608323d-507d-4cbf-bf74-52007f8124ea",
            "sender": {
              "name": "sdisZ",
              "URI": "hubsante:fr.fire.sdisZ"
            },
            "sentAt": "2022-09-27T08:23:34+02:00",
            "status": "Actual",
            "kind": "Report",
            "recipient": [
              {
                "name": "samuA",
                "URI": "hubsante:fr.health.samuA"
              }
            ],
            "createCaseHealth": {
              "caseId": "fr.health.samu440.DRFR154402413800862",
              "senderCaseId": "DRFR154402413800862",
              "creation": "2024-05-26T13:15:00+02:00",
              "qualification": {
                "whatsHappen": {
                  "code": "C02.05.02",
                  "label": "Obst\\u00e9trique"
                },
                "healthMotive": {
                  "code": "M03.02",
                  "label": "Autre probl\\u00e8me obst\\u00e9trique non h\\u00e9morragique"
                },
                "locationKind": {
                  "code": "L04.02.00",
                  "label": "Centre commercial / magasin"
                },
                "riskThreat": [
                  {
                    "label": "Implication d\\u2019une personnalit\\u00e9",
                    "code": "R25"
                  }
                ],
                "details": {
                  "priority": "P2"
                }
              },
              "location": {
                "name": "Centre Commercial Atlantis",
                "detailedAddress": {
                  "complete": "4, Boulevard Salvador Allende",
                  "number": "4",
                  "wayName": {
                    "complete": "Boulevard Salvador Allende",
                    "type": "Boulevard",
                    "name": "Salvador Allende"
                  }
                },
                "city": {
                  "name": "Saint-Herblain",
                  "inseeCode": "44162"
                },
                "access": {
                  "floor": "RDC",
                  "buildingName": "Soleil",
                  "entrance": "B",
                  "roomNumber": "B",
                  "interphone": "Dubois",
                  "accessCode": [
                    "1234A"
                  ],
                  "elevator": "B"
                },
                "externalLocationId": [
                  {
                    "source": "SIRET",
                    "value": "70142121200018"
                  }
                ],
                "geometry": {
                  "point": {
                    "coord": {
                      "lon": -1.6318399,
                      "lat": 47.2224055,
                      "precision": "EXACTE"
                    }
                  },
                  "datetime": "2024-05-26T11:16:00+02:00"
                },
                "externalInfo": [
                  {
                    "freetext": "BAN",
                    "type": "PHOTO",
                    "uri": "AZ1234"
                  }
                ],
                "freetext": "Magasin bleu et jaune\\nD\\u00e9tails de commune : Saint-Marthe"
              },
              "initialAlert": {
                "reception": "2024-05-26T13:15:00+02:00",
                "caller": {
                  "callerContact": {
                    "type": "TEL",
                    "detail": "+33671832618",
                    "channel": "PERSONNE"
                  },
                  "callbackContact": {
                    "type": "TEL",
                    "detail": "+33671832618",
                    "channel": "PERSONNE"
                  },
                  "detailedName": {
                    "complete": "Agn\\u00e8s Duberti",
                    "lastName": "Duberti",
                    "firstName": "Agn\\u00e8s"
                  },
                  "type": "TIERS",
                  "communication": "AUCUNE",
                  "language": "fr",
                  "freetext": "Coll\\u00e8gue de travail de la victime"
                },
                "notes": [
                  {
                    "freetext": "count: \'1\'\\nfreetext: Femme enceinte de 2 mois qui est tomb\\u00e9 d\'une \\u00e9chelle au bureau. Delphine\\n  Vigneau, 32 ans.\\nmainVictim: ADULTE\\n; - URI: https://hub.esante.gouv.fr/\\n  description: PHOTO\\n; calltakerContact:\\n  channel: PERSONNE\\n  detail: \'+33162863746\'\\n  type: TEL\\ncalltakerId: ARM1234\\ncontrolRoom: CRRA44\\norganization: fr.health.samu440\\nrole: ARM\\n; - Mari m\\u00e9decin\\n"
                  }
                ]
              },
              "additionalInformation": {
                "customMap": [
                  {
                    "key": "COMMERCIAL",
                    "value": "IKEA Nantes"
                  }
                ]
              },
              "owner": "fr.health.samuA"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotCisuConverter::test_snapshot_RC_EDA_required_field_message 1'] = '''{
  "distributionID": "fr.fire.sdisZ_2608323d-507d-4cbf-bf74-52007f8124ea",
  "senderID": "fr.fire.sdisZ",
  "dateTimeSent": "2022-09-27T08:23:34+02:00",
  "dateTimeExpires": "2072-09-27T08:23:34+02:00",
  "distributionStatus": "Actual",
  "distributionKind": "Report",
  "descriptor": {
    "language": "fr-FR",
    "explicitAddress": {
      "explicitAddressScheme": "hubex",
      "explicitAddressValue": "fr.health.samuA"
    }
  },
  "content": [
    {
      "jsonContent": {
        "embeddedJsonContent": {
          "message": {
            "messageId": "2608323d-507d-4cbf-bf74-52007f8124ea",
            "sender": {
              "name": "sdisZ",
              "URI": "hubsante:fr.fire.sdisZ"
            },
            "sentAt": "2022-09-27T08:23:34+02:00",
            "status": "Actual",
            "kind": "Report",
            "recipient": [
              {
                "name": "samuA",
                "URI": "hubsante:fr.health.samuA"
              }
            ],
            "createCaseHealth": {
              "caseId": "fr.health.samu440.DRFR154402413800862",
              "creation": "2024-05-26T13:15:00+02:00",
              "qualification": {
                "whatsHappen": {
                  "code": "C02.05.02",
                  "label": "Obst\\u00e9trique"
                }
              },
              "location": {
                "freetext": ""
              },
              "owner": "fr.health.samuA"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotCisuConverter::test_snapshot_RS_EDA_exhaustive_bis_message 1'] = '''{
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
      "explicitAddressValue": "fr.fire.sdisZ"
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
                "name": "sdisZ",
                "URI": "hubsante:fr.fire.sdisZ"
              }
            ],
            "createCase": {
              "caseId": "fr.health.samu950.DRFR159502401800159",
              "creation": "2024-01-18T18:00:00+01:00",
              "qualification": {
                "whatsHappen": {
                  "code": "C02.08.02",
                  "label": "Atteinte aux personnes ; Traumatisme / Accident ; Accident domestique"
                },
                "locationKind": {
                  "code": "L01.02.10",
                  "label": "Domicile ; Lieu d\'habitation collectif ou foyer d\'h\\u00e9bergement ;  escaliers"
                },
                "healthMotive": {
                  "code": "M02.07",
                  "label": "Traumatisme s\\u00e9rieux, plaie interm\\u00e9diaire"
                },
                "riskThreat": [
                  {
                    "code": "R20",
                    "label": "Difficult\\u00e9 d\\u2019acc\\u00e8s sur site"
                  }
                ],
                "victims": {
                  "count": "PLUSIEURS"
                }
              },
              "location": {
                "detailedAddress": {
                  "complete": "4 rue Danielle Mitterrand",
                  "number": "4",
                  "wayName": {
                    "complete": "rue Danielle Mitterrand",
                    "type": "rue",
                    "name": "Danielle Mitterrand"
                  }
                },
                "city": {
                  "name": "Bezons",
                  "inseeCode": "95063"
                },
                "freetext": "dans la cage d\\u2019escalier B",
                "geometry": {
                  "point": {
                    "coord": {
                      "lat": 48.92399978637695,
                      "lon": 2.2162439823150635,
                      "precision": "ADRESSE"
                    }
                  },
                  "datetime": "2024-01-17T21:06:00+01:00"
                },
                "access": {
                  "accessCode": [
                    "5678"
                  ],
                  "floor": "3",
                  "interphone": "Halimi",
                  "elevator": "ESC B",
                  "buildingName": "A",
                  "roomNumber": "2",
                  "entrance": "B"
                },
                "locID": "LOC-20240210123456-f5de",
                "country": "FR"
              },
              "initialAlert": {
                "reception": "2024-01-18T18:00:00+01:00",
                "caller": {
                  "callerContact": {
                    "type": "TEL",
                    "detail": "+33702880946",
                    "channel": "PERSONNE"
                  },
                  "language": "fr",
                  "detailedName": {
                    "complete": "Amina BERTRAND  ",
                    "lastName": "BERTRAND  ",
                    "firstName": "Amina"
                  },
                  "type": "TIERS",
                  "callbackContact": {
                    "channel": "PERSONNE",
                    "type": "TEL",
                    "detail": "+33617263546"
                  },
                  "communication": "AUCUNE",
                  "freetext": "Choqu\\u00e9 par les \\u00e9v\\u00e8nements"
                },
                "notes": [
                  {
                    "freetext": "Chute enfant dans les escaliers",
                    "creation": "2024-01-18T18:01:00+01:00"
                  }
                ],
                "id": "INAL-20240210123456-f5de",
                "callTaker": {
                  "organization": "fr.health.samuA",
                  "controlRoom": "CRRA samuA"
                },
                "reporting": "ATTENTION",
                "qualification": {
                  "whatsHappen": {
                    "code": "C02.08.02",
                    "label": "Atteinte aux personnes ; Traumatisme / Accident ; Accident domestique"
                  },
                  "locationKind": {
                    "code": "L01.02.10",
                    "label": "Domicile ; Lieu d\'habitation collectif ou foyer d\'h\\u00e9bergement ;  escaliers"
                  },
                  "healthMotive": {
                    "code": "M02.07",
                    "label": "Traumatisme s\\u00e9rieux, plaie interm\\u00e9diaire"
                  },
                  "riskThreat": [
                    {
                      "code": "R20",
                      "label": "Difficult\\u00e9 d\\u2019acc\\u00e8s sur site"
                    }
                  ],
                  "victims": {
                    "count": "PLUSIEURS"
                  }
                },
                "location": {
                  "detailedAddress": {
                    "complete": "4 rue Danielle Mitterrand",
                    "number": "4",
                    "wayName": {
                      "complete": "rue Danielle Mitterrand",
                      "type": "rue",
                      "name": "Danielle Mitterrand"
                    }
                  },
                  "city": {
                    "name": "Bezons",
                    "inseeCode": "95063"
                  },
                  "freetext": "dans la cage d\\u2019escalier B",
                  "geometry": {
                    "point": {
                      "coord": {
                        "lat": 48.92399978637695,
                        "lon": 2.2162439823150635,
                        "precision": "ADRESSE"
                      }
                    },
                    "datetime": "2024-01-17T21:06:00+01:00"
                  },
                  "access": {
                    "accessCode": [
                      "5678"
                    ],
                    "floor": "3",
                    "interphone": "Halimi",
                    "elevator": "ESC B",
                    "buildingName": "A",
                    "roomNumber": "2",
                    "entrance": "B"
                  },
                  "locID": "LOC-20240210123456-f5de",
                  "country": "FR"
                }
              },
              "senderCaseId": "DRFR159502401800159",
              "additionalInformation": {
                "customMap": [
                  {
                    "key": "neighborhood",
                    "label": "Quartier",
                    "value": "Saint-Marthe",
                    "freetext": "Nom du quartier d\'intervention"
                  }
                ]
              },
              "referenceVersion": "2.0"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotCisuConverter::test_snapshot_RS_EDA_exhaustive_message 1'] = '''{
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
      "explicitAddressValue": "fr.fire.sdisZ"
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
                "name": "sdisZ",
                "URI": "hubsante:fr.fire.sdisZ"
              }
            ],
            "createCase": {
              "caseId": "fr.health.samu950.DRFR159502401800159",
              "creation": "2024-01-18T18:00:00+01:00",
              "qualification": {
                "whatsHappen": {
                  "code": "C02.08.02",
                  "label": "Atteinte aux personnes ; Traumatisme / Accident ; Accident domestique"
                },
                "locationKind": {
                  "code": "L01.02.10",
                  "label": "Domicile ; Lieu d\'habitation collectif ou foyer d\'h\\u00e9bergement ;  escaliers"
                },
                "healthMotive": {
                  "code": "M02.07",
                  "label": "Traumatisme s\\u00e9rieux, plaie interm\\u00e9diaire"
                },
                "riskThreat": [
                  {
                    "code": "R20",
                    "label": "Difficult\\u00e9 d\\u2019acc\\u00e8s sur site"
                  }
                ],
                "victims": {
                  "count": "1"
                }
              },
              "location": {
                "detailedAddress": {
                  "complete": "4 rue Danielle Mitterrand",
                  "number": "4",
                  "wayName": {
                    "complete": "rue Danielle Mitterrand",
                    "type": "rue",
                    "name": "Danielle Mitterrand"
                  }
                },
                "city": {
                  "name": "Bezons",
                  "inseeCode": "95063"
                },
                "freetext": "dans la cage d\\u2019escalier B",
                "geometry": {
                  "point": {
                    "coord": {
                      "lat": 48.92399978637695,
                      "lon": 2.2162439823150635,
                      "precision": "ADRESSE"
                    }
                  },
                  "datetime": "2024-01-17T21:06:00+01:00"
                },
                "access": {
                  "accessCode": [
                    "5678"
                  ],
                  "floor": "3",
                  "interphone": "Halimi",
                  "elevator": "ESC B",
                  "buildingName": "A",
                  "roomNumber": "2",
                  "entrance": "B"
                },
                "locID": "LOC-20240210123456-f5de",
                "country": "FR"
              },
              "initialAlert": {
                "reception": "2024-01-18T18:00:00+01:00",
                "caller": {
                  "callerContact": {
                    "type": "TEL",
                    "detail": "+33702880946",
                    "channel": "PERSONNE"
                  },
                  "language": "fr",
                  "detailedName": {
                    "complete": "Amina BERTRAND  ",
                    "lastName": "BERTRAND  ",
                    "firstName": "Amina"
                  },
                  "type": "TIERS",
                  "callbackContact": {
                    "channel": "PERSONNE",
                    "type": "TEL",
                    "detail": "+33617263546"
                  },
                  "communication": "AUCUNE",
                  "freetext": "Choqu\\u00e9 par les \\u00e9v\\u00e8nements"
                },
                "notes": [
                  {
                    "freetext": "Chute enfant dans les escaliers",
                    "creation": "2024-01-18T18:01:00+01:00"
                  }
                ],
                "id": "INAL-20240210123456-f5de",
                "callTaker": {
                  "organization": "fr.health.samuA",
                  "controlRoom": "CRRA samuA"
                },
                "reporting": "STANDARD",
                "qualification": {
                  "whatsHappen": {
                    "code": "C02.08.02",
                    "label": "Atteinte aux personnes ; Traumatisme / Accident ; Accident domestique"
                  },
                  "locationKind": {
                    "code": "L01.02.10",
                    "label": "Domicile ; Lieu d\'habitation collectif ou foyer d\'h\\u00e9bergement ;  escaliers"
                  },
                  "healthMotive": {
                    "code": "M02.07",
                    "label": "Traumatisme s\\u00e9rieux, plaie interm\\u00e9diaire"
                  },
                  "riskThreat": [
                    {
                      "code": "R20",
                      "label": "Difficult\\u00e9 d\\u2019acc\\u00e8s sur site"
                    }
                  ],
                  "victims": {
                    "count": "1"
                  }
                },
                "location": {
                  "detailedAddress": {
                    "complete": "4 rue Danielle Mitterrand",
                    "number": "4",
                    "wayName": {
                      "complete": "rue Danielle Mitterrand",
                      "type": "rue",
                      "name": "Danielle Mitterrand"
                    }
                  },
                  "city": {
                    "name": "Bezons",
                    "inseeCode": "95063"
                  },
                  "freetext": "dans la cage d\\u2019escalier B",
                  "geometry": {
                    "point": {
                      "coord": {
                        "lat": 48.92399978637695,
                        "lon": 2.2162439823150635,
                        "precision": "ADRESSE"
                      }
                    },
                    "datetime": "2024-01-17T21:06:00+01:00"
                  },
                  "access": {
                    "accessCode": [
                      "5678"
                    ],
                    "floor": "3",
                    "interphone": "Halimi",
                    "elevator": "ESC B",
                    "buildingName": "A",
                    "roomNumber": "2",
                    "entrance": "B"
                  },
                  "locID": "LOC-20240210123456-f5de",
                  "country": "FR"
                }
              },
              "senderCaseId": "DRFR159502401800159",
              "additionalInformation": {
                "customMap": [
                  {
                    "key": "neighborhood",
                    "label": "Quartier",
                    "value": "Saint-Marthe",
                    "freetext": "Nom du quartier d\'intervention"
                  }
                ]
              },
              "referenceVersion": "2.0"
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotCisuConverter::test_snapshot_RS_EDA_required_field_message 1'] = '''{
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
      "explicitAddressValue": "fr.fire.sdisZ"
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
                "name": "sdisZ",
                "URI": "hubsante:fr.fire.sdisZ"
              }
            ],
            "createCase": {
              "caseId": "fr.health.samu950.DRFR159502401800159",
              "creation": "2024-01-18T18:00:00+01:00",
              "qualification": {
                "whatsHappen": {
                  "code": "C02.08.02",
                  "label": "Atteinte aux personnes ; Traumatisme / Accident ; Accident domestique"
                },
                "victims": {
                  "count": "0"
                }
              },
              "location": {
                "detailedAddress": {
                  "complete": "4 rue Danielle Mitterrand",
                  "number": "4",
                  "wayName": {
                    "complete": "rue Danielle Mitterrand",
                    "type": "rue",
                    "name": "Danielle Mitterrand"
                  }
                },
                "locID": "LOC-20240210123456-f5de",
                "country": "FR"
              },
              "referenceVersion": "2.0"
            }
          }
        }
      }
    }
  ]
}'''
