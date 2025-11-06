# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots["TestSnapshotV1V2Converter::test_snapshot_V1_to_V2_upgrade 1"] = """{
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
                "origin": "112",
                "riskThreat": [
                  {
                    "code": "R01",
                    "label": "libell\\u00e9 R01"
                  }
                ],
                "whatsHappen": {
                  "code": "C02.16.01",
                  "label": "libell\\u00e9 de C021501"
                },
                "locationKind": {
                  "code": "L01.00.00",
                  "label": "libell\\u00e9 type de lieu"
                },
                "healthMotive": {
                  "code": "M03.11",
                  "label": "libell\\u00e9 motif de recours"
                },
                "details": {
                  "status": " ACTIF",
                  "attribution": "DRM.SPE.PEDIA",
                  "priority": "P1",
                  "careLevel": "R3"
                }
              },
              "location": {
                "geometry": {
                  "point": {
                    "coord": {
                      "lat": 37.7749,
                      "lon": 122.4194,
                      "height": 16,
                      "precision": "INCONNUE"
                    },
                    "isAml": true
                  },
                  "datetime": "2025-02-27T06:30:00+01:00"
                },
                "name": "nom du lieu",
                "externalLocationId": [
                  {
                    "source": "SIREN",
                    "value": "123456789"
                  }
                ],
                "detailedAddress": {
                  "highway": {
                    "name": "A4",
                    "pk": "PK10",
                    "direction": "est"
                  },
                  "complete": "12 rue de nulle part",
                  "number": "12",
                  "wayName": {
                    "complete": "rue de nulle part",
                    "type": "rue",
                    "name": "de nulle part"
                  }
                },
                "city": {
                  "name": "nowhere",
                  "inseeCode": "99999"
                },
                "access": {
                  "floor": "1",
                  "roomNumber": "12",
                  "interphone": "45678",
                  "accessCode": [
                    "4598"
                  ],
                  "elevator": "z",
                  "buildingName": "E",
                  "entrance": "EST",
                  "entity": "Service",
                  "phoneNumber": "+33156487811"
                },
                "externalInfo": [
                  {
                    "freetext": "BAN",
                    "type": "PHOTO",
                    "uri": "identifiantBAN"
                  }
                ],
                "freetext": "infos compl\\u00e9mentaires sur le lieu"
              },
              "initialAlert": {
                "caller": {
                  "callerContact": {
                    "channel": "PERSONNE",
                    "type": "TEL",
                    "detail": "+33645897846457895"
                  },
                  "callbackContact": {
                    "channel": "ECALL",
                    "type": "FAX",
                    "detail": "uriducontact"
                  },
                  "language": "fr",
                  "type": "MED.MEDSOS",
                  "communication": "LANGUE",
                  "freetext": "infos supp sur le requ\\u00e9rant",
                  "detailedName": {
                    "complete": "pr\\u00e9nom et nom du requ\\u00e9rant",
                    "lastName": "nom du requ\\u00e9rant",
                    "firstName": "pr\\u00e9nom du requ\\u00e9rant"
                  }
                },
                "reception": "2025-02-13T15:00:00+01:00",
                "notes": [
                  {
                    "creation": "2025-02-27T00:00:00+01:00",
                    "freetext": "commentaire alerte initiale"
                  },
                  {
                    "creation": "2025-02-27T00:00:00+01:00",
                    "freetext": "commentaire alerte initiale 2"
                  }
                ]
              },
              "caseId": "fr.health.samu770.DRFR157702400400055",
              "senderCaseId": "DRFR157702400400055",
              "creation": "2025-02-27T01:15:00+01:00",
              "perimeter": "AMU",
              "interventionType": "PRIMAIRE",
              "owner": "fr.health.samu770",
              "patient": [
                {
                  "administrativeFile": {
                    "externalId": [
                      {
                        "source": "NIR",
                        "value": "154088045698715"
                      }
                    ]
                  },
                  "identity": {
                    "strictFeatures": {
                      "birthName": "Nom de naissance",
                      "birthDate": "1954-08-12",
                      "sex": "M"
                    },
                    "nonStrictFeatures": {
                      "complete": "pr\\u00e9nom et nom",
                      "lastName": "nom",
                      "firstName": "pr\\u00e9nom"
                    }
                  },
                  "healthMotive": {
                    "code": "M01.00",
                    "label": "D\\u00e9tresse vitale"
                  },
                  "detail": {
                    "weight": 80,
                    "height": 178,
                    "age": "P80Y",
                    "careLevel": "R2"
                  },
                  "hypothesis": {
                    "mainDiagnosis": {
                      "code": "J14",
                      "label": " Pneumopathie due \\u00e0 Haemophilus influenzae"
                    },
                    "otherDiagnosis": [
                      {
                        "code": "E11.9",
                        "label": "Diab\\u00e8te sucr\\u00e9 de type 2 sans complication"
                      }
                    ]
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1"
                },
                {
                  "administrativeFile": {
                    "externalId": [
                      {
                        "source": "DOSSARD",
                        "value": "blablabla"
                      }
                    ]
                  },
                  "identity": {
                    "strictFeatures": {
                      "birthName": "nom de naissance 2",
                      "birthDate": "1959-05-23",
                      "sex": "F"
                    },
                    "nonStrictFeatures": {
                      "complete": "pr\\u00e9nom et nom 2",
                      "lastName": "nom 2",
                      "firstName": "pr\\u00e9nom 2"
                    }
                  },
                  "healthMotive": {
                    "code": "M02.01",
                    "label": "Blessure"
                  },
                  "detail": {
                    "weight": 54,
                    "height": 160,
                    "age": "P65Y",
                    "careLevel": "R4"
                  },
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.2"
                }
              ],
              "medicalNote": [
                {
                  "operator": {
                    "label": "Label 1",
                    "role": "ARM"
                  },
                  "creation": "2025-02-27T12:06:00+01:00",
                  "freetext": "Note li\\u00e9e \\u00e0 un patient n\\u00b01",
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "medicalNoteId": "fr.health.samu770.medicalNote.nimpnawak"
                },
                {
                  "operator": {
                    "label": "label 2",
                    "role": "AUTRE"
                  },
                  "creation": "2025-02-27T00:00:00+01:00",
                  "freetext": "note m\\u00e9dicale non li\\u00e9e \\u00e0 patient n\\u00b02",
                  "medicalNoteId": "fr.health.samu770.medicalNote.onsenfout"
                },
                {
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "medicalNoteId": "fr.health.samu770.medicalNote.f5de7hj",
                  "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\\nlabel: Faux code\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.2",
                  "medicalNoteId": "fr.health.samu770.medicalNote.a3b2YH8",
                  "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\\nlabel: Pas CIM 10\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                },
                {
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.2",
                  "medicalNoteId": "fr.health.samu770.medicalNote.c9d8jk9",
                  "freetext": "Diagnostique principal : code: 4A00\\nlabel: Code CIM11\\n",
                  "operator": {
                    "role": "AUTRE"
                  }
                }
              ],
              "decision": [
                {
                  "operator": {
                    "label": "label 3",
                    "role": "MEDECIN"
                  },
                  "creation": "2025-02-27T00:00:00+01:00",
                  "decisionType": "CONSEIL",
                  "resourceType": "TSU ",
                  "medicalTransport": true,
                  "orientationType": "EPHAD",
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.1"
                },
                {
                  "operator": {
                    "role": "INFIRMIER"
                  },
                  "creation": "2025-02-27T18:00:00+01:00",
                  "decisionType": "ORIENT",
                  "resourceType": "LIBERAL",
                  "orientationType": "URGENCES",
                  "patientId": "fr.health.samu770.patient.DRFR157702400400055.2"
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
}"""

snapshots["TestSnapshotV1V2Converter::test_snapshot_V2_to_V1_downgrade 1"] = """{
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
                "origin": "116117",
                "riskThreat": [
                  {
                    "code": "R06",
                    "label": "libR06"
                  }
                ],
                "whatsHappen": {
                  "code": "C02.14.04",
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
                  "status": "CLASSE",
                  "attribution": "DRM",
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
                  "obsDatime": "2025-02-06T00:00:00+01:00"
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
                    "channel": "ECALL",
                    "type": "POSTAL",
                    "detail": "laposte"
                  },
                  "callbackContact": {
                    "channel": "DAU",
                    "type": "RADIO",
                    "detail": "radiolaposte"
                  },
                  "type": "AMBULANC",
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
              "interventionType": "SECONDAIRE",
              "owner": "fr.health.samu770",
              "patient": [
                {
                  "administrativeFile": {
                    "externalId": [
                      {
                        "source": "NIR",
                        "value": "123456789123"
                      },
                      {
                        "source": "DOSSARD",
                        "value": "Numero dossard"
                      }
                    ]
                  },
                  "identity": {
                    "strictFeatures": {
                      "birthName": "Naissance patient 0",
                      "birthDate": "2005-02-05",
                      "sex": "AUTRE"
                    },
                    "nonStrictFeatures": {
                      "complete": "pr\\u00e9nom et nom patient 0",
                      "lastName": "nom patient 0",
                      "firstName": "pr\\u00e9nom patient 0"
                    }
                  },
                  "healthMotive": {
                    "code": "M06.03",
                    "label": "libelle m0603"
                  },
                  "detail": {
                    "weight": 56,
                    "height": 2000,
                    "age": "P20Y",
                    "careLevel": "R1"
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
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1"
                },
                {
                  "administrativeFile": {
                    "externalId": [
                      {
                        "source": "PLACE",
                        "value": "place"
                      }
                    ]
                  },
                  "identity": {
                    "strictFeatures": {
                      "sex": "INCONNU",
                      "birthName": "nom naissance 1",
                      "birthDate": "2010-04-20"
                    },
                    "nonStrictFeatures": {
                      "complete": "prenom nom 1",
                      "lastName": "nom2",
                      "firstName": "prenom1"
                    }
                  },
                  "healthMotive": {
                    "code": "M06.04",
                    "label": "libell\\u00e9"
                  },
                  "detail": {
                    "weight": 32,
                    "height": 90,
                    "age": "P15Y",
                    "careLevel": "R1"
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.2"
                }
              ],
              "medicalNote": [
                {
                  "operator": {
                    "label": "labello",
                    "role": "AMBULANCIER"
                  },
                  "creation": "2025-02-27T12:00:00+01:00",
                  "freetext": " note 0",
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "idObs": "fr.health.samu770.medicalNote.bout1.bout2"
                },
                {
                  "operator": {
                    "label": "label",
                    "role": "AUTRE"
                  },
                  "creation": "2025-02-27T00:00:00+01:00",
                  "freetext": "note1",
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "idObs": "fr.health.samu770.medicalNote.partie1.partie2"
                },
                {
                  "operator": {
                    "role": "INCONNU"
                  },
                  "creation": "2025-02-27T00:00:00+01:00",
                  "freetext": "note2",
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "idObs": "fr.health.samu770.patient.medicalNote.partie1seulement"
                },
                {
                  "freetext": "Traitements : traitement zero\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "idObs": "fr.health.samu770.medicalNote.f5de7hj"
                },
                {
                  "freetext": "Ant\\u00e9c\\u00e9dents : antecedent zero\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "idObs": "fr.health.samu770.medicalNote.a3b2YH8"
                },
                {
                  "freetext": "M\\u00e9decin traitant : Contact(s) :\\n-  email@email.com\\n   -  EMAIL\\n-  \'+334564789541657\'\\n   -  TEL\\n\\n  Nom complet : Medecin traitant\\n  Pr\\u00e9nom:  medecin\\n  Nom : traitant\\nIdentifiant RPPS : \'12345678901\'\\n",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1",
                  "idObs": "fr.health.samu770.medicalNote.c9d8jk9"
                },
                {
                  "freetext": "Traitements : antecedent\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.2",
                  "idObs": "fr.health.samu770.medicalNote.he9i0kz"
                },
                {
                  "freetext": "Ant\\u00e9c\\u00e9dents : antecendent\\n...\\n",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.2",
                  "idObs": "fr.health.samu770.medicalNote.ye7jk6k"
                },
                {
                  "freetext": "M\\u00e9decin traitant : Contact(s) :\\n-  email@mss.pro\\n   -  EMAIL\\n-  \'103.7\'\\n   -  RADIO\\n\\n  Nom complet : pr\\u00e9nom nom 1\\n  Pr\\u00e9nom:  pr\\u00e9nom\\n  Nom : nom 1\\nIdentifiant RPPS : \'12345678901\'\\n",
                  "operator": {
                    "role": "AUTRE"
                  },
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.2",
                  "idObs": "fr.health.samu770.medicalNote.pe9rd2t"
                }
              ],
              "decision": [
                {
                  "operator": {
                    "label": "label",
                    "role": "ARM"
                  },
                  "creation": "2025-02-27T00:00:00+01:00",
                  "decisionType": "INTER",
                  "resourceType": "SMUR",
                  "orientationType": "SANTE",
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1"
                },
                {
                  "operator": {
                    "role": "MEDECIN"
                  },
                  "creation": "2025-02-27T12:00:00+01:00",
                  "decisionType": "ORIENT",
                  "resourceType": "LIB",
                  "medicalTransport": true,
                  "orientationType": "DOMICILE",
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1"
                },
                {
                  "operator": {
                    "role": "AUTRE",
                    "label": "label2"
                  },
                  "creation": "2025-02-27T00:00:00+01:00",
                  "decisionType": "PMT",
                  "resourceType": "FDO",
                  "orientationType": "AUTRE",
                  "idPat": "fr.health.samu770.patient.DRFR157702400400055.1"
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
}"""
