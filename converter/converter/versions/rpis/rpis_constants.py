class RpisConstants:
    RESOURCE_TYPE_PATH = "$.orientation.decision.resourceType"
    V3_TO_V2_RESOURCE_TYPE_MAPPING = {"TSU": "TSU "}

    REGULATION_MEDICAL_LEVEL_PATH = "$.regulation.medicalLevel"
    ORIENTATION_MEDICAL_LEVEL_PATH = "$.orientation.decision.medicalLevel"
    V3_TO_V2_MEDICAL_LEVEL_MAPPING = {"SANS": "MED"}

    # whatsHappen: CNF codes - Map v2.0 codes to v1.18 equivalents
    WHATS_HAPPEN_CODE_PATH = "$.regulation.whatsHappen.code"
    V3_TO_V2_WHATS_HAPPEN_CODE_MAPPING = {
        "C02.06.02": "C02.06.00",  # Intoxication CO → Intoxication
        "C02.18.00": "C02.05.00",  # Problème psychiatrique → Pathologie/maladie
        # C01.06 codes (road accident followed by fire) → C01.01 (road accident not followed by fire)
        "C01.06.00": "C01.01.00",  # Accident routier suivi de feu → Accident routier non suivi de feu
        "C01.06.01": "C01.01.01",  # Véhicule léger + feu → Véhicule léger
        "C01.06.02": "C01.01.02",  # Poids lourd + feu → Poids lourd
        "C01.06.03": "C01.01.03",  # Bus/car + feu → Bus/car
        "C01.06.04": "C01.01.01",  # Plusieurs véhicules légers + feu → Véhicule léger
        "C01.06.05": "C01.01.06",  # Carambolage + feu → Carambolage
    }

    # healthMotive: MRMS codes - Map v2.0 codes to v1.18 equivalents  
    HEALTH_MOTIVE_CODE_PATH = "$.regulation.healthMotive.code"
    V3_TO_V2_HEALTH_MOTIVE_CODE_MAPPING = {
        "M08.00.00": "M01.00",  # Personne inconsciente → Détresse vitale
        "M08.01.00": "M01.01",  # Pas de mouvement ventilatoire → Suspicion arrêt cardiaque
        "M08.02.00": "M01.01",  # Arrêt cardio-respiratoire → Suspicion arrêt cardiaque
        "M08.03.00": "M01.02",  # Inconscient qui respire → Altération de la conscience
        # M16 codes (Intoxication v2.0) → Map to v1.18 M04 (Intoxications) and M01 (vital distress for severe)
        "M16.00.00": "M04.00",  # Intoxication → Intoxications
        "M16.01.00": "M04.02",  # Intoxication au CO / fumées → Intoxication involontaire
        "M16.01.01": "M01.02",  # Intoxication CO avec convulsions/troubles conscience → Altération conscience
        "M16.01.02": "M04.02",  # Intoxication CO vomissements/céphalées → Intoxication involontaire
        "M16.01.03": "M04.02",  # Intoxication CO sans gravité → Intoxication involontaire
        "M16.02.00": "M04.03",  # Intoxication éthylique ou stupéfiants → Ébriété, ivresse
        "M16.02.01": "M01.02",  # Intoxication éthylique/stupéfiants convulsions/coma → Altération conscience
        "M16.02.02": "M04.03",  # Intoxication éthylique/stupéfiants somnolence → Ébriété, ivresse
        "M16.02.03": "M04.03",  # Intoxication éthylique/stupéfiants sans gravité → Ébriété, ivresse
        "M16.03.00": "M04.01",  # Médicamenteuse → Intoxication volontaire et sevrage
        "M16.03.01": "M01.02",  # Médicamenteuse avec convulsions/coma → Altération conscience
        "M16.03.02": "M01.03",  # Médicamenteuse avec détresse respiratoire → Détresse respiratoire
        "M16.03.03": "M04.01",  # Médicamenteuse somnolence → Intoxication volontaire
        "M16.03.04": "M04.01",  # Médicamenteuse sans gravité → Intoxication volontaire
        "M16.04.00": "M04.02",  # Chimiques/venimeuses → Intoxication involontaire
        "M16.04.01": "M01.02",  # Chimiques/venimeuses convulsions/troubles conscience → Altération conscience
        "M16.04.02": "M01.03",  # Chimiques/venimeuses détresse respiratoire → Détresse respiratoire
        "M16.04.03": "M04.02",  # Chimiques/venimeuses sans gravité → Intoxication involontaire
        # M13 codes (Traumatisme v2.0) → Map to v1.18 M02 (Blessure) or M01 (for severe cases)
        "M13.00.00": "M02.00",  # Traumatisme → Blessure
        "M13.01.00": "M06.03",  # Personne restant à terre suite chute → Personne restant à terre suite chute
        "M13.02.00": "M02.08",  # Suspicion victime polytraumatisé → Traumatisme grave, plaie délabrante
        "M13.03.00": "M02.07",  # Traumatisme tête-cou → Traumatisme sérieux
        "M13.03.01": "M01.02",  # Trauma tête-cou avec perte conscience → Altération conscience
        "M13.03.02": "M02.06",  # Trauma tête-cou sans gravité → Traumatisme bénin
        "M13.04.00": "M02.07",  # Traumatisme thorax → Traumatisme sérieux
        "M13.04.01": "M01.03",  # Trauma thorax avec gêne respiratoire → Détresse respiratoire
        "M13.04.02": "M02.06",  # Trauma thorax sans gravité → Traumatisme bénin
        "M13.05.00": "M02.07",  # Traumatisme abdomen-bassin → Traumatisme sérieux
        "M13.05.01": "M02.08",  # Trauma abdomen-bassin choc violent → Traumatisme grave
        "M13.05.02": "M02.06",  # Trauma abdomen-bassin sans gravité → Traumatisme bénin
        "M13.06.00": "M02.07",  # Traumatisme membres → Traumatisme sérieux
        "M13.06.01": "M02.09",  # Amputation → Section complète de membre
        "M13.06.02": "M02.08",  # Fracture ouverte → Traumatisme grave
        "M13.06.03": "M02.07",  # Fracture fermée → Traumatisme sérieux
        "M13.06.04": "M02.07",  # Déformation → Traumatisme sérieux
        "M13.06.05": "M02.06",  # Trauma membres sans gravité → Traumatisme bénin
        "M13.07.00": "M02.06",  # Traumatisme doigts-orteils → Traumatisme bénin
        "M13.07.01": "M02.09",  # Amputation doigt → Section complète de doigts
        "M13.07.02": "M02.07",  # Fracture ouverte doigt → Traumatisme sérieux
        "M13.07.03": "M02.06",  # Fracture fermée doigt → Traumatisme bénin
        "M13.07.04": "M02.06",  # Déformation doigt → Traumatisme bénin
        "M13.07.05": "M02.06",  # Trauma doigt sans gravité → Traumatisme bénin
        # M14 codes (Plaies v2.0) → Map to v1.18 M02 (Blessure)
        "M14.00.00": "M02.00",  # Plaies → Blessure
        "M14.01.00": "M02.08",  # Pénétrante → Traumatisme grave, plaie délabrante
        "M14.01.01": "M02.08",  # Plaie étendue → Traumatisme grave
        "M14.01.02": "M02.08",  # Plaies multiples → Traumatisme grave
        "M14.01.03": "M02.08",  # Plaie grave crâne → Traumatisme grave
        "M14.01.04": "M02.08",  # Plaie grave visage → Traumatisme grave
        "M14.01.05": "M02.08",  # Plaie grave cou → Traumatisme grave
        "M14.01.06": "M02.08",  # Plaie grave thorax-abdomen → Traumatisme grave
        "M14.01.07": "M02.08",  # Pâleur, soif, prostration → Traumatisme grave
        "M14.02.00": "M02.06",  # Morsure → Traumatisme bénin
        "M14.02.01": "M02.07",  # Morsure grave → Traumatisme sérieux
        "M14.02.02": "M02.06",  # Morsure sans gravité → Traumatisme bénin
    }

    # location type: Type de lieu codes - Map v2.0 codes to v1.18 parent
    LOCATION_TYPE_PATH = "$.intervention.location.type"
    V3_TO_V2_LOCATION_TYPE_MAPPING = {
        "L04.06.06": "L04.06.00",  # Map new V3 location code to parent category in V2
        "L01.02.14": "L01.02.00",  # Balcon/terrasse → Lieu d'habitation collectif
        "L02.01.01": "L02.01.00",  # Tunnel → Voie publique hors voie rapide
        "L02.01.02": "L02.01.00",  # Piste cyclable → Voie publique hors voie rapide
        "L02.01.03": "L02.01.00",  # Pont/viaduc → Voie publique hors voie rapide
    }
