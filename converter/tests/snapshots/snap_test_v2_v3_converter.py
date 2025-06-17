# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots['TestSnapshotV2V3Converter::test_snapshot_V2_to_V3_upgrade 1'] = '''{
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
            "createCaseHealth": {
              "qualification": {
                "origin": "CTA-CONF",
                "riskThreat": [
                  {
                    "code": "R06",
                    "label": "libR06"
                  }
                ],
                "whatsHappen": {
                  "code": "C02.15.04",
                  "label": "libelleC021504"
                },
                "locationKind": {
                  "code": "L01.01.04",
                  "label": "libell\\u00e9 type de lieu"
                },
                "healthMotive": {
                  "code": "M01.02",
                  "label": "libelleM0102"
                },
                "details": {
                  "status": "ACTIF",
                  "attribution": "DRM.SPE.OBST",
                  "priority": "NR",
                  "careLevel": "R4"
                }
              },
              "location": {
                "geometry": {
                  "point": {
                    "coord": {
                      "lat": 22,
                      "lon": 22,
                      "height": 22,
                      "precision": "EXACTE"
                    },
                    "isAml": true
                  },
                  "datetime": "2025-02-06T00:00:00+01:00"
                },
                "name": "nom du lieu",
                "externalLocationId": [
                  {
                    "source": "FINESS_ADMINISTRATIF",
                    "value": "123456789"
                  }
                ],
                "detailedAddress": {
                  "highway": {
                    "name": "A1",
                    "pk": "PK2645",
                    "direction": "Sud"
                  },
                  "complete": "56-22 boulevard du d\\u00e9sespoir",
                  "number": "56-22",
                  "wayName": {
                    "complete": "boulevard du d\\u00e9sespoir",
                    "type": "boulevard ",
                    "name": "du d\\u00e9sespoir"
                  }
                },
                "city": {
                  "name": "Desesperance",
                  "inseeCode": "12345"
                },
                "access": {
                  "floor": "56",
                  "roomNumber": "9",
                  "interphone": "Silence",
                  "accessCode": [
                    "7896542"
                  ],
                  "elevator": "A",
                  "buildingName": "C",
                  "entrance": "Z",
                  "entity": "service",
                  "phoneNumber": "+3345678945678"
                },
                "externalInfo": [
                  {
                    "freetext": "IGN",
                    "type": "AUTRE",
                    "uri": "autreidentifiant"
                  },
                  {
                    "freetext": "NEXSIS",
                    "type": "CARTE",
                    "uri": "carteajouer"
                  }
                ],
                "freetext": "informations compl\\u00e9mentaires sur la localisation"
              },
              "initialAlert": {
                "caller": {
                  "callerContact": {
                    "channel": "DEFIBRILLATEUR,",
                    "type": "POSTAL",
                    "detail": "laposte"
                  },
                  "callbackContact": {
                    "channel": "DEFIBRILLATEUR,",
                    "type": "RADIO",
                    "detail": "radiolaposte"
                  },
                  "language": "af",
                  "type": "AMBULANC.AASC",
                  "communication": "HOSTILE",
                  "freetext": "info supp requ\\u00e9rant",
                  "detailedName": {
                    "complete": "prenom nom requerant",
                    "lastName": "nom requerant",
                    "firstName": "prenom requerant"
                  }
                },
                "reception": "2025-02-27T00:00:00+01:00",
                "notes": [
                  {
                    "creation": "2025-02-27T00:00:00+01:00",
                    "freetext": "alerte initiale 1"
                  },
                  {
                    "creation": "2025-02-27T00:00:00+01:00",
                    "freetext": "alerte initiale 2"
                  }
                ]
              },
              "caseId": "fr.health.samu770.DRFR157702400400055",
              "senderCaseId": "DRFR157702400400055.2",
              "creation": "2025-02-27T12:00:00+01:00",
              "perimeter": "PSY",
              "interventionType": "T2-INTER",
              "owner": "fr.health.samu770",
              "patient": [
                {
                  "administrativeFile": {
                    "generalPractitioner": {
                      "detailedName": {
                        "complete": "Medecin traitant",
                        "lastName": "traitant",
                        "firstName": "medecin"
                      },
                      "rppsId": "12345678901",
                      "contact": [
                        {
                          "type": "EMAIL",
                          "detail": "email@email.com"
                        },
                        {
                          "type": "TEL",
                          "detail": "+334564789541657"
                        }
                      ]
                    },
                    "externalId": [
                      {
                        "source": "DOSSARD",
                        "value": "Numero dossard"
                      }
                    ]
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "identity": {
                    "strictFeatures": {
                      "birthName": "Naissance patient 0",
                      "birthDate": "2005-02-05",
                      "sex": "O"
                    },
                    "nonStrictFeatures": {
                      "complete": "pr\\u00e9nom et nom patient 0",
                      "lastName": "nom patient 0",
                      "firstName": "pr\\u00e9nom patient 0"
                    }
                  },
                  "detail": {
                    "weight": 56,
                    "height": 2000,
                    "age": "P20Y",
                    "careLevel": "R1",
                    "medicalHistory": "antecedent zero",
                    "treatment": "traitement zero"
                  },
                  "hypothesis": {
                    "mainDiagnosis": {
                      "code": "G40.9",
                      "label": "test"
                    },
                    "otherDiagnosis": [
                      {
                        "code": "M54.5",
                        "label": "libelle M54.5"
                      },
                      {
                        "code": "K21.0",
                        "label": "libelle K21.0"
                      }
                    ]
                  }
                },
                {
                  "administrativeFile": {
                    "generalPractitioner": {
                      "detailedName": {
                        "complete": "pr\\u00e9nom nom 1",
                        "lastName": "nom 1",
                        "firstName": "pr\\u00e9nom"
                      },
                      "rppsId": "12345678901",
                      "contact": [
                        {
                          "type": "MSS",
                          "detail": "email@mss.pro"
                        },
                        {
                          "type": "RADIO",
                          "detail": "103.7"
                        }
                      ]
                    },
                    "externalId": [
                      {
                        "source": "PLACE",
                        "value": "place"
                      }
                    ]
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.2",
                  "identity": {
                    "strictFeatures": {
                      "sex": "UN",
                      "birthName": "nom naissance 1",
                      "birthDate": "2010-04-20"
                    },
                    "nonStrictFeatures": {
                      "complete": "prenom nom 1",
                      "lastName": "nom2",
                      "firstName": "prenom1"
                    }
                  },
                  "detail": {
                    "weight": 32,
                    "height": 90,
                    "age": "P15Y",
                    "careLevel": "R1",
                    "medicalHistory": "antecendent",
                    "treatment": "antecedent"
                  }
                }
              ],
              "medicalNote": [
                {
                  "operator": {
                    "label": "labello",
                    "role": "AMBULANCIER"
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "medicalNoteId": "fr.health.samu770.medicalNote.bout1.bout2",
                  "creation": "2025-02-27T12:00:00+01:00",
                  "freetext": " note 0"
                },
                {
                  "operator": {
                    "label": "label",
                    "role": "AUTRE"
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "medicalNoteId": "fr.health.samu770.medicalNote.partie1.partie2",
                  "creation": "2025-02-27T00:00:00+01:00",
                  "freetext": "note1"
                },
                {
                  "operator": {
                    "role": "INCONNU"
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "medicalNoteId": "fr.health.samu770.patient.medicalNote.partie1seulement",
                  "creation": "2025-02-27T00:00:00+01:00",
                  "freetext": "note2"
                },
                {
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "medicalNoteId": "fr.health.samu770.medicalNote.f5de7hj",
                  "freetext": "Motif de recours m\\u00e9dico-secouriste : code: M06.03\\nlabel: libelle m0603\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "medicalNoteId": "fr.health.samu770.medicalNote.a3b2YH8",
                  "freetext": "Identifiant(s) patient(s) : Type : SI-VIC\\nValeur : \'123456789123\'\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.2",
                  "medicalNoteId": "fr.health.samu770.medicalNote.c9d8jk9",
                  "freetext": "Motif de recours m\\u00e9dico-secouriste : code: M06.04\\nlabel: libell\\u00e9\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                }
              ],
              "decision": [
                {
                  "operator": {
                    "label": "label",
                    "role": "ARM"
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "creation": "2025-02-27T00:00:00+01:00",
                  "decisionType": "INTER",
                  "resourceType": "SMUR.PED",
                  "orientationType": "SANTE"
                },
                {
                  "operator": {
                    "role": "MEDECIN"
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "creation": "2025-02-27T12:00:00+01:00",
                  "decisionType": "ORIENT",
                  "resourceType": "LIBERAL.SOS",
                  "medicalTransport": true,
                  "orientationType": "DOMICILE"
                },
                {
                  "operator": {
                    "role": "AUTRE",
                    "label": "label2"
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "creation": "2025-02-27T00:00:00+01:00",
                  "decisionType": "PMT",
                  "resourceType": "FDO.GEND",
                  "orientationType": "AUTRE"
                }
              ],
              "additionalInformation": {
                "customMap": [
                  {
                    "key": "test",
                    "label": "test",
                    "value": "test",
                    "freetext": "test"
                  }
                ]
              }
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotV2V3Converter::test_snapshot_V3_to_V2_bis_downgrade 1'] = '''{
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
            "createCaseHealth": {
              "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8",
              "senderCaseId": "DRFR154402414300123",
              "creation": "2024-05-26T13:15:00+02:00",
              "qualification": {
                "riskThreat": [
                  {
                    "code": "R32",
                    "label": "Patient/Victime confin\\u00e9"
                  }
                ],
                "whatsHappen": {
                  "code": "C02.15.01",
                  "label": "Rixe ou bagarre"
                },
                "locationKind": {
                  "code": "L07.01.00",
                  "label": "Autre lieu d\'intervention"
                },
                "healthMotive": {
                  "code": "M06.04",
                  "label": "Autre motif"
                },
                "details": {
                  "priority": "P2",
                  "attribution": "DRM.SPE",
                  "status": "PROGRAMME"
                }
              },
              "location": {
                "detailedAddress": {
                  "complete": "Boulevard Salvador Allende",
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
                  "buildingName": "Soleil"
                },
                "geometry": {
                  "point": {
                    "coord": {
                      "lat": 47.146089,
                      "lon": -1.691374,
                      "precision": "EXACTE"
                    }
                  },
                  "datetime": "2024-05-26T13:13:00+02:00"
                },
                "externalLocationId": [
                  {
                    "source": "SIRET",
                    "value": "70142121200018"
                  }
                ],
                "name": "Centre Commercial Atlantis"
              },
              "initialAlert": {
                "reception": "2024-05-26T13:15:00+02:00",
                "caller": {
                  "callerContact": {
                    "type": "TEL",
                    "detail": "+33671832618",
                    "channel": "PERSONNE"
                  },
                  "detailedName": {
                    "complete": "Agn\\u00e8s Duberti",
                    "lastName": "Duberti",
                    "firstName": "Agn\\u00e8s"
                  },
                  "language": "fr",
                  "type": "TIERS",
                  "callbackContact": {
                    "channel": "DEFIBRILLATEUR, ",
                    "type": "TEL",
                    "detail": "+33671832618"
                  },
                  "communication": "AUCUNE"
                }
              },
              "patient": [
                {
                  "identity": {
                    "nonStrictFeatures": {
                      "complete": "Delphine Vigneau",
                      "lastName": "Vigneau",
                      "firstName": "Delphine"
                    },
                    "strictFeatures": {
                      "sex": "F",
                      "birthDate": "1992-03-03"
                    }
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "detail": {
                    "age": "P32Y"
                  },
                  "hypothesis": {
                    "mainDiagnosis": {
                      "code": "O20",
                      "label": "H\\u00e9morragie en d\\u00e9but de grossesse"
                    }
                  },
                  "administrativeFile": {
                    "generalPractitioner": {
                      "detailedName": {
                        "complete": "Medecin traitant",
                        "lastName": "traitant",
                        "firstName": "medecin"
                      },
                      "rppsId": "12345678901",
                      "contact": [
                        {
                          "type": "EMAIL",
                          "detail": "email@email.com"
                        },
                        {
                          "type": "TEL",
                          "detail": "+334564789541657"
                        }
                      ]
                    },
                    "externalId": [
                      {
                        "source": "DOSSARD",
                        "value": "Numero dossard"
                      }
                    ]
                  }
                },
                {
                  "identity": {
                    "nonStrictFeatures": {
                      "complete": "Cl\\u00e9ment Thomas",
                      "lastName": "Thomas",
                      "firstName": "Cl\\u00e9ment"
                    },
                    "strictFeatures": {
                      "sex": "F",
                      "birthDate": "1992-03-03"
                    }
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.2",
                  "detail": {
                    "age": "P32Y"
                  },
                  "hypothesis": {
                    "mainDiagnosis": {
                      "code": "O20",
                      "label": "H\\u00e9morragie en d\\u00e9but de grossesse"
                    }
                  }
                }
              ],
              "owner": "fr.health.samu440",
              "additionalInformation": {
                "customMap": [
                  {
                    "key": "COMMERCIAL",
                    "value": "IKEA Nantes"
                  }
                ]
              },
              "interventionType": "PRIMAIRE",
              "decision": [
                {
                  "operator": {
                    "role": "PILOTE",
                    "label": "R\\u00e9mi Martin"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "creation": "2024-05-26T13:20:00+02:00",
                  "decisionType": "INTER",
                  "resourceType": "SMUR"
                },
                {
                  "operator": {
                    "role": "MEDECIN",
                    "label": "Jean Pat"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "creation": "2024-05-26T13:20:00+02:00",
                  "decisionType": "INTER",
                  "resourceType": "SMUR",
                  "orientationType": "AUTRE"
                }
              ],
              "medicalNote": [
                {
                  "creation": "2024-05-18T18:15:00+02:00",
                  "freetext": "Asthmatique",
                  "operator": {
                    "role": "ARM"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402413800236.2",
                  "medicalNoteId": "fr.health.samu440.medicalNote.0001"
                },
                {
                  "creation": "2024-05-18T18:15:00+02:00",
                  "freetext": "Asthmatique",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402413800236.2",
                  "medicalNoteId": "fr.health.samu440.medicalNote.0001"
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.f5de7hj",
                  "freetext": "Origine de l`appel : AUTOCOM\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.a3b2YH8",
                  "freetext": "Identifiant(s) patient(s) : Local v\\u00e9lo\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.c9d8jk9",
                  "freetext": "Identifiant(s) patient(s) : R\\u00e9action allergique\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "medicalNoteId": "fr.health.samu440.medicalNote.he9i0kz",
                  "freetext": "Type de l`identifiant fourni : Type : AUTRE\\nValeur : \'123456789123\'\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.ye7jk6k",
                  "freetext": "Destination : Identifiant(s) du lieu:\\n\\n- Type : FINESS_GEOGRAPHIQUE\\n  Valeur : \'680020096\'\\nInformations compl\\u00e9mentaires : H\\u00f4pital Saint-Louis\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                }
              ]
            }
          }
        }
      }
    }
  ]
}'''

snapshots['TestSnapshotV2V3Converter::test_snapshot_V3_to_V2_downgrade 1'] = '''{
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
            "createCaseHealth": {
              "caseId": "fr.fire.sis044.cga-044.SC-20240526-044-cga-AL8",
              "senderCaseId": "DRFR154402414300123",
              "creation": "2024-05-26T13:15:00+02:00",
              "qualification": {
                "whatsHappen": {
                  "code": "C02.13.00",
                  "label": "Obst\\u00e9trique"
                },
                "locationKind": {
                  "code": "L01.02.00",
                  "label": "Local v\\u00e9lo"
                },
                "healthMotive": {
                  "code": "M03.00",
                  "label": "R\\u00e9action allergique"
                },
                "details": {
                  "priority": "P2",
                  "attribution": "DRM.SPE",
                  "status": "PROGRAMME"
                }
              },
              "location": {
                "detailedAddress": {
                  "complete": "Boulevard Salvador Allende",
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
                  "buildingName": "Soleil"
                },
                "geometry": {
                  "point": {
                    "coord": {
                      "lat": 47.146089,
                      "lon": -1.691374,
                      "precision": "EXACTE"
                    }
                  },
                  "datetime": "2024-05-26T13:13:00+02:00"
                },
                "externalLocationId": [
                  {
                    "source": "SIRET",
                    "value": "70142121200018"
                  }
                ],
                "name": "Centre Commercial Atlantis"
              },
              "initialAlert": {
                "reception": "2024-05-26T13:15:00+02:00",
                "caller": {
                  "callerContact": {
                    "type": "TEL",
                    "detail": "+33671832618",
                    "channel": "PERSONNE"
                  },
                  "detailedName": {
                    "complete": "Agn\\u00e8s Duberti",
                    "lastName": "Duberti",
                    "firstName": "Agn\\u00e8s"
                  },
                  "language": "fr",
                  "type": "TIERS",
                  "callbackContact": {
                    "channel": "DEFIBRILLATEUR, ",
                    "type": "TEL",
                    "detail": "+33671832618"
                  },
                  "communication": "AUCUNE"
                }
              },
              "patient": [
                {
                  "identity": {
                    "nonStrictFeatures": {
                      "complete": "Delphine Vigneau",
                      "lastName": "Vigneau",
                      "firstName": "Delphine"
                    },
                    "strictFeatures": {
                      "sex": "F",
                      "birthDate": "1992-03-03"
                    }
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "detail": {
                    "age": "P32Y"
                  },
                  "hypothesis": {
                    "mainDiagnosis": {
                      "code": "O20",
                      "label": "H\\u00e9morragie en d\\u00e9but de grossesse"
                    }
                  },
                  "administrativeFile": {
                    "generalPractitioner": {
                      "detailedName": {
                        "complete": "Medecin traitant",
                        "lastName": "traitant",
                        "firstName": "medecin"
                      },
                      "rppsId": "12345678901",
                      "contact": [
                        {
                          "type": "EMAIL",
                          "detail": "email@email.com"
                        },
                        {
                          "type": "TEL",
                          "detail": "+334564789541657"
                        }
                      ]
                    },
                    "externalId": [
                      {
                        "source": "DOSSARD",
                        "value": "Numero dossard"
                      }
                    ]
                  }
                },
                {
                  "identity": {
                    "nonStrictFeatures": {
                      "complete": "Cl\\u00e9ment Thomas",
                      "lastName": "Thomas",
                      "firstName": "Cl\\u00e9ment"
                    },
                    "strictFeatures": {
                      "sex": "F",
                      "birthDate": "1992-03-03"
                    }
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.2",
                  "detail": {
                    "age": "P32Y"
                  },
                  "hypothesis": {
                    "mainDiagnosis": {
                      "code": "O20",
                      "label": "H\\u00e9morragie en d\\u00e9but de grossesse"
                    }
                  }
                }
              ],
              "owner": "fr.health.samu440",
              "additionalInformation": {
                "customMap": [
                  {
                    "key": "COMMERCIAL",
                    "value": "IKEA Nantes"
                  }
                ]
              },
              "decision": [
                {
                  "operator": {
                    "role": "PILOTE",
                    "label": "R\\u00e9mi Martin"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "creation": "2024-05-26T13:20:00+02:00",
                  "decisionType": "INTER",
                  "resourceType": "SMUR"
                },
                {
                  "operator": {
                    "role": "MEDECIN",
                    "label": "Jean Pat"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "creation": "2024-05-26T13:20:00+02:00",
                  "decisionType": "INTER",
                  "resourceType": "SMUR",
                  "orientationType": "AUTRE"
                }
              ],
              "medicalNote": [
                {
                  "creation": "2024-05-18T18:15:00+02:00",
                  "freetext": "Asthmatique",
                  "operator": {
                    "role": "ARM"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402413800236.2",
                  "medicalNoteId": "fr.health.samu440.medicalNote.0001"
                },
                {
                  "creation": "2024-05-18T18:15:00+02:00",
                  "freetext": "Asthmatique",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "patientId": "fr.health.samu440.patient.DRFR154402413800236.2",
                  "medicalNoteId": "fr.health.samu440.medicalNote.0001"
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.f5de7hj",
                  "freetext": "Origine de l`appel : AUTOCOM\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.a3b2YH8",
                  "freetext": "Type d`intervention : RAPAT/EVASAN - T4\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.c9d8jk9",
                  "freetext": "Risque, menace et sensibilit\\u00e9 : code: R38\\nlabel: Non pr\\u00e9cis\\u00e9\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "patientId": "fr.health.samu440.patient.DRFR154402414300123.1",
                  "medicalNoteId": "fr.health.samu440.medicalNote.he9i0kz",
                  "freetext": "Type de l`identifiant fourni : Type : AUTRE\\nValeur : \'123456789123\'\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "medicalNoteId": "fr.health.samu440.medicalNote.ye7jk6k",
                  "freetext": "Destination : Identifiant(s) du lieu:\\n\\n- Type : FINESS_GEOGRAPHIQUE\\n  Valeur : \'680020096\'\\nInformations compl\\u00e9mentaires : H\\u00f4pital Saint-Louis\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                }
              ]
            }
          }
        }
      }
    }
  ]
}'''
