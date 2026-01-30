class RpisConstants:
    RESOURCE_TYPE_PATH = "$.orientation.decision.resourceType"
    V3_TO_V2_RESOURCE_TYPE_MAPPING = {"TSU": "TSU "}

    REGULATION_MEDICAL_LEVEL_PATH = "$.regulation.medicalLevel"
    ORIENTATION_MEDICAL_LEVEL_PATH = "$.orientation.decision.medicalLevel"
    V3_TO_V2_MEDICAL_LEVEL_MAPPING = {"SANS": "MED"}

    # whatsHappen: CNF codes - Map v2.0 codes to v1.18 equivalents
    WHATS_HAPPEN_CODE_PATH = "$.regulation.whatsHappen.code"
    V3_TO_V2_WHATS_HAPPEN_CODE_MAPPING = {
        "C01.01.07": "C01.01.00",  # Accident routier d'engin de chantier, agricole
        "C01.02.03": "C01.02.00",  # Collision train - piéton
        "C01.02.04": "C01.02.00",  # Collision  tramway - piéton
        "C01.02.05": "C01.02.00",  # Déraillement train de voyageurs
        "C01.02.06": "C01.02.00",  # Déraillement train de marchandises
        "C01.02.07": "C01.02.00",  # Déraillement tram, tramway
        # C01.06 codes (road accident followed by fire) → C01.01 (road accident not followed by fire)
        "C01.06.00": "C01.01.00",  # Accident routier suivi de feu → Accident routier non suivi de feu
        "C01.06.01": "C01.01.01",  # Véhicule léger + feu → Véhicule léger
        "C01.06.02": "C01.01.02",  # Poids lourd + feu → Poids lourd
        "C01.06.03": "C01.01.03",  # Bus/car + feu → Bus/car
        "C01.06.04": "C01.01.01",  # Plusieurs véhicules légers + feu → Véhicule léger
        "C01.06.05": "C01.01.06",  # Carambolage + feu → Carambolage
        "C01.03.03": "C01.03.00",  # Accident bateau de pêche
        "C01.03.04": "C01.03.00",  # Accident bateau de guerre
        "C01.03.05": "C01.03.00",  # Accident bateau de plaisance, sports nautiques
        "C01.04.05": "C01.04.00",  # Accident aéronef de tourisme
        "C01.04.06": "C01.04.00",  # Accident ULM, planeur, mongolfiière
        "C02.06.02": "C02.06.00",  # Intoxication CO → Intoxication
        "C02.07.06": "C02.07.04",  # Personne foudroyée
        "C02.07.07": "C02.07.04",  # Personne exposée à des rayonnements ou radioéléments
        "C02.10.01": "C02.11.00",  # Personne visible dans l'eau
        "C02.10.02": "C02.11.00",  # Noyade
        "C02.10.03": "C02.11.00",  # Personne sortie de l'eau suite à noyade
        "C02.10.04": "C02.11.00",  # Engin nautique à la dérive avec présence humaine à bord
        "C02.12.01": "C02.12.00",  # Personne ensevelie
        "C02.12.02": "C02.12.00",  # Personne envasée, ensablée, ensilée
        "C02.12.03": "C02.12.00",  # Personne bloquée en hauteur
        "C02.12.04": "C02.12.00",  # Personne bloquée dans un ascenseur
        "C02.12.05": "C02.12.00",  # Personne enfermée
        "C02.12.06": "C02.12.00",  # Personne piégée, coincée
        "C02.12.07": "C02.12.00",  # Personne ne pouvant se relever seule
        "C02.13.09": "C02.13.00",  # Tentative de suicide par gaz / monoxyde de carbone
        "C02.15.07": "C02.15.00",  # Téléphone grave danger
        "C02.15.08": "C02.15.00",  # Bracelet anti-rapprochement
        "C02.17.00": "C10.02.00",  # Découverte de cadavre/mort suspecte
        "C02.17.01": "C10.02.00",  # Découverte de cadavre
        "C02.17.02": "C10.02.00",  # Mort suspecte
        "C02.18.00": "C02.05.00",  # Problème psychiatrique → Pathologie/maladie
        "C02.19.00": "C02.08.00",  # Différends et litiges inter-personnels
        "C02.19.01": "C02.08.00",  # Différend familial
        "C02.19.02": "C02.08.00",  # Non représentation d'enfant
        "C02.19.03": "C02.08.00",  # Différend de voisinage
        "C02.19.04": "C02.08.00",  # Autres différends
        "C02.19.05": "C02.08.00",  # Litiges
        "C04.01.12": "C04.01.00",  # Incendie Engin de chantier ou agricole
        "C04.01.13": "C04.01.00",  # Incendie Plusieurs véhicules légers
        "C04.01.14": "C04.01.00",  # Incendie Tram, tramway
        "C04.01.15": "C04.01.00",  # Incendie Bateau de plaisance
        "C04.01.16": "C04.01.00",  # Incendie Bateau de pêche
        "C04.01.17": "C04.01.00",  # Incendie bateau de guerre
        "C04.01.18": "C04.01.00",  # Incendie ULM, planeur, mongolfière
        "C04.01.19": "C04.01.00",  # Incendie aéronef de tourisme
        "C04.02.05": "C04.02.00",  # Incendie d'ERP avec locaux à sommeil
        "C04.02.06": "C04.02.00",  # Incendie d'ERP sans locaux à sommeil
        "C04.05.01": "C04.03.00",  # Incendie de haie, herbes sèches
        "C04.05.02": "C04.03.00",  # Feu de chaumes, récoltes
        "C04.05.03": "C04.03.00",  # Feu de broussailles
        "C04.05.04": "C04.03.00",  # Feu de forêt
        "C04.10.00": "C04.00.00",  # Incendie d'un élément, structure
        "C04.10.01": "C04.00.00",  # Feu de cheminée
        "C04.10.02": "C04.00.00",  # Incendie d'origine électrique
        "C04.10.03": "C04.00.00",  # Autre feu d'un élément, structure
        "C04.11.00": "C04.00.00",  # Fumée suspecte, levée de doute
        "C06.03.07": "C06.03.00",  # Refus d'obtempérer
        "C07.02.01": "C07.02.00",  # Affrontement bande
        "C07.02.02": "C07.02.00",  # Dégradation mobilier urbain
        "C07.02.03": "C07.02.00",  # Incendie
        "C07.02.04": "C07.02.00",  # Autres violences urbaines
        "C08.01.01": "C02.08.03",  # Montée des eaux inquietante
        "C08.01.02": "C02.08.03",  # Inondation d'un batiment, local
        "C08.05.01": "C02.08.03",  # Chute d'arbres
        "C08.05.02": "C02.08.03",  # Dommages sur toitures
        "C08.06.01": "C02.08.03",  # Bâtiment
        "C08.06.02": "C02.08.03",  # Carrière
        "C08.06.03": "C02.08.03",  # Autre éboulement, effondrement
        "C08.08.03": "C02.08.03",  # Pollution aérienne
        "C08.08.04": "C02.08.03",  # Fut, bidon suspect
        "C09.03.02": "C02.08.03",  # Fuite de gaz enflammée (réseau)
        "C09.03.03": "C02.08.03",  # Fuite de gaz non enflammée (réseau)
        "C09.03.04": "C02.08.03",  # Fuite de gaz sur bouteille
        "C09.04.03": "C02.08.03",  # Vapeur sous pression / chauffage urbain
        "C09.05.01": "C02.08.03",  # Immeuble en péril
        "C09.05.02": "C02.08.03",  # Menace ou chute de matériaux
        "C09.06.01": "C02.08.03",  # Avec présence de personne vulnérable
        "C09.06.02": "C02.08.03",  # Vide d'occupant
        "C11.01.01": "C02.08.03",  # Alarme incendie
        "C11.01.02": "C02.08.03",  # Alarme vol / intrusion
        "C11.01.03": "C02.08.03",  # Secours à personne (téléalarme et applications mobiles)
        "C11.01.04": "C02.08.03",  # Dispositif travailleur isolé
        "C11.01.05": "C02.08.03",  # Simple alarme sans précision
        "C11.05.04": "C02.08.03",  # Problème technique sur un véhicule
        "C11.05.05": "C02.08.03",  # Obstruction de chaussée
        "C11.05.06": "C02.08.03",  # Obstruction de voie ferrée
        "C11.05.07": "C02.08.03",  # Obstruction de voie naviguable
        "C11.07.00": "C02.08.03",  # Requisition judiciaire
        "C11.08.00": "C02.08.03",  # Odeur suspecte
    }

    # healthMotive: MRMS codes - Map v2.0 codes to v1.18 equivalents  
    HEALTH_MOTIVE_CODE_PATH = "$.regulation.healthMotive.code"
    V3_TO_V2_HEALTH_MOTIVE_CODE_MAPPING = {
        "M08.00.00": "M01.00",  # Personne inconsciente → Détresse vitale
        "M08.01.00": "M01.01",  # Pas de mouvement ventilatoire → Suspicion arrêt cardiaque
        "M08.02.00": "M01.01",  # Arrêt cardio-respiratoire → Suspicion arrêt cardiaque
        "M08.03.00": "M01.02",  # Inconscient qui respire → Altération de la conscience
        # M09: Hémorragies / Saignements → M02.01 (Saignements) or M02.02 (Hémorragie sévère)
        "M09.00.00": "M02.01",  # Hémorragies / Saignements
        "M09.01.00": "M02.02",  # Hémorragie ne pouvant être stoppée
        "M09.01.01": "M02.02",  # Epistaxis non stoppée par compression
        "M09.02.00": "M02.01",  # Hémorragie extériorisée
        "M09.02.01": "M02.01",  # Hémorragie digestive
        "M09.02.02": "M02.01",  # Hémorragie extériorisée - Malaise
        "M09.02.03": "M02.01",  # Crache du sang en toussant
        "M09.02.04": "M02.01",  # Saignement peut être stoppé par compression
        "M09.02.05": "M02.01",  # Epistaxis stoppée par compression
        "M09.03.00": "M02.01",  # Saignements bénins
        "M09.03.01": "M02.01",  # Saignement sans signe de gravité
        # M10: Circulatoire → M03.06 (Douleur thoracique) or M03.09 (Malaise)
        "M10.00.00": "M03.06",  # Circulatoire
        "M10.01.00": "M03.06",  # Palpitations
        "M10.02.00": "M03.09",  # Autres troubles circulatoires
        "M10.02.01": "M03.09",  # Victime déjà choquée par un DAI
        "M10.02.02": "M03.09",  # Fréquence cardiaque < 50 ou > 150
        "M10.02.03": "M03.09",  # Tension artérielle < 90 mm Hg
        "M10.02.04": "M03.09",  # Tension artérielle > 160 mm Hg
        "M10.02.05": "M03.09",  # Autre trouble sans signe de gravité
        # M11: Respiration → M01.03 (Détresse respiratoire) or M03.11 (Problème respiratoire)
        "M11.00.00": "M01.03",  # Respiration
        "M11.01.00": "M01.03",  # Détresse respiratoire
        "M11.01.01": "M01.03",  # Etat asphyxique
        "M11.01.02": "M01.03",  # Epuisement respiratoire chez un nourrisson
        "M11.02.00": "M03.11",  # Difficultés respiratoires
        "M11.02.01": "M03.11",  # Respiration bruyante
        "M11.02.02": "M03.11",  # Sueurs et/ou troubles de conscience
        "M11.02.03": "M03.11",  # Difficultés respiratoires sans signe de gravité
        "M11.03.00": "M03.11",  # Autres problème respiratoire
        "M11.03.01": "M03.11",  # Problème isol  é d appareillage respiratoire
        "M11.03.02": "M03.11",  # Corps étranger expulsé
        "M11.03.03": "M03.11",  # Obstruction partielle
        "M11.03.04": "M03.11",  # Autres problème respiratoire sans signe de gravité
        # M12: Neurologie → M03.08 (AVC), M03.07 (Problème neurologique), M03.09/10 (Malaise)
        "M12.00.00": "M03.07",  # Neurologie
        "M12.01.00": "M03.08",  # Suspicion AVC / AIT
        "M12.01.01": "M03.08",  # Avec troubles de la conscience
        "M12.01.02": "M03.08",  # Sans céphalée ou vomissement ni trouble de la conscience
        "M12.01.03": "M03.08",  # Avec disparition des signes associés à l'AVC
        "M12.02.00": "M03.07",  # Convulsions persistantes
        "M12.03.00": "M03.07",  # Convulsions
        "M12.03.01": "M03.07",  # Chez la femme enceinte
        "M12.03.02": "M03.07",  # Hyperthermiques de l'enfant
        "M12.03.03": "M03.07",  # Réveil après convulsions
        "M12.04.00": "M03.10",  # Trouble de la conscience
        "M12.04.01": "M03.10",  # Chez le diabétique
        "M12.04.02": "M03.10",  # Avec perte de connaissance initiale
        "M12.04.03": "M03.10",  # Somnolent et capable de parler
        "M12.04.04": "M03.10",  # Confusion, désorientation
        "M12.04.05": "M03.10",  # Trouble de la conscience sans signe de gravité
        "M12.05.00": "M03.09",  # Malaise
        "M12.05.01": "M03.09",  # Malaise sans signe de gravité
        "M12.05.02": "M03.09",  # Malaise d effort
        "M12.05.03": "M03.09",  # Avec perte de connaissance initiale
        "M12.05.04": "M03.09",  # Avec trouble de la conscience
        "M12.06.00": "M03.07",  # Autre motif neurologique
        "M12.06.01": "M03.07",  # Céphalées
        "M12.06.02": "M03.07",  # Céphalées avec vomissement
        "M12.06.03": "M03.07",  # Autre motif neurologique sans signe de gravité
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
        # M15: Brûlures → M02.04 (Brûlure grave) or M02.05 (Brûlure sans gravité)
        "M15.00.00": "M02.04",  # Brûlures
        "M15.01.00": "M02.04",  # Brûlure de la tête, du cou
        "M15.01.01": "M02.05",  # Brûlure tête/cou sans gravité
        "M15.01.02": "M02.05",  # Brûlure tête/cou sans gravité
        "M15.01.03": "M02.05",  # Brûlure tête/cou sans gravité
        "M15.02.00": "M02.04",  # Brûlure du thorax, abdomen, bassin
        "M15.02.01": "M02.05",  # Brûlure thorax/abdomen sans gravité
        "M15.02.02": "M02.05",  # Brûlure thorax/abdomen sans gravité
        "M15.02.03": "M02.05",  # Brûlure thorax/abdomen sans gravité
        "M15.03.00": "M02.04",  # Brûlure des membres
        "M15.03.01": "M02.05",  # Brûlure membres sans gravité
        "M15.03.02": "M02.05",  # Brûlure membres sans gravité
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
        # M17: Problèmes ORL → M03.12 (Problème ORL)
        "M17.00.00": "M03.12",  # Problèmes ORL
        "M17.01.00": "M03.12",  # Problème œil
        "M17.01.01": "M03.12",  # Corps étranger dans l'œil
        "M17.01.02": "M03.12",  # Douleur à l'œil
        "M17.01.03": "M03.12",  # Autre problème ophtalmologique
        "M17.02.00": "M03.12",  # Problème oreille
        "M17.02.01": "M03.12",  # Autre problème auriculaire
        "M17.03.00": "M03.12",  # Problème nez
        "M17.03.01": "M03.12",  # Saignement de nez
        "M17.03.02": "M03.12",  # Corps étranger dans le nez
        "M17.03.03": "M03.12",  # Autre problème nasal
        "M17.04.00": "M03.12",  # Problème bouche, gorge
        "M17.04.01": "M03.12",  # Corps étranger dans la bouche
        "M17.04.02": "M03.12",  # Autre problème buccal
        "M17.05.00": "M03.12",  # Problème dentaire
        "M17.05.01": "M03.12",  # Rage de dents
        "M17.05.02": "M03.12",  # Dent cassée
        "M17.05.03": "M03.12",  # Dent expulsée
        "M17.05.04": "M03.12",  # Autre problème dentaire
        # M18: Problèmes digestifs → M03.13 (Problème digestif)
        "M18.00.00": "M03.13",  # Problèmes digestifs
        "M18.01.00": "M03.13",  # Douleur abdominale
        "M18.01.01": "M03.13",  # Douleur abdominale intense
        "M18.01.02": "M03.13",  # Douleur abdominale modérée
        "M18.01.03": "M03.13",  # Douleur abdominale avec vomissement
        "M18.01.04": "M03.13",  # Douleur abdominale avec diarrhée
        "M18.01.05": "M03.13",  # Douleur abdominale avec constipation
        "M18.01.06": "M03.13",  # Douleur abdominale avec fièvre
        "M18.01.07": "M03.13",  # Autre douleur abdominale
        "M18.02.00": "M03.13",  # Autre problème digestif
        "M18.02.01": "M03.13",  # Vomissement
        "M18.02.02": "M03.13",  # Diarrhée
        "M18.02.03": "M03.13",  # Constipation
        "M18.02.04": "M03.13",  # Nausée
        "M18.02.05": "M03.13",  # Autre problème digestif
        # M19: Douleurs → M03.15 (Douleurs)
        "M19.00.00": "M03.15",  # Douleurs
        "M19.01.00": "M03.15",  # Douleur thoracique non traumatique
        "M19.02.00": "M03.15",  # Douleur membre
        "M19.02.01": "M03.15",  # Douleur épaule
        "M19.02.02": "M03.15",  # Douleur coude
        "M19.02.03": "M03.15",  # Douleur poignet, main
        "M19.02.04": "M03.15",  # Douleur hanche
        "M19.02.05": "M03.15",  # Douleur genou
        "M19.02.06": "M03.15",  # Douleur cheville, pied
        "M19.03.00": "M03.15",  # Douleur dos, rachis
        "M19.04.00": "M03.15",  # Douleur tête, cou
        "M19.05.00": "M03.15",  # Douleur bassin
        "M19.06.00": "M03.15",  # Douleur atypique
        "M19.06.01": "M03.15",  # Douleur généralisée
        "M19.06.02": "M03.15",  # Douleur localisée inhabituelle
        "M19.06.03": "M03.15",  # Douleur chronique
        "M19.06.04": "M03.15",  # Douleur aiguë
        "M19.06.05": "M03.15",  # Autre douleur
        "M19.07.00": "M03.15",  # Douleur articulaire
        "M19.07.01": "M03.15",  # Douleur articulaire épaule
        "M19.07.02": "M03.15",  # Douleur articulaire coude
        "M19.07.03": "M03.15",  # Douleur articulaire hanche
        "M19.07.04": "M03.15",  # Douleur articulaire genou
        "M19.08.00": "M03.15",  # Autres douleurs
        # M20: Problèmes de santé spécifiques → M03.14 (Autre problème médical)
        "M20.00.00": "M03.14",  # Problèmes de santé spécifiques
        "M20.01.00": "M03.14",  # Problème lié à un appareil médical
        "M20.02.00": "M03.14",  # Problème dermatologique
        "M20.03.00": "M03.14",  # Problème urinaire
        "M20.04.00": "M03.14",  # Autre problème de santé spécifique
    }

    # location type: Type de lieu codes - Map v2.0 codes to v1.18 parent
    LOCATION_TYPE_PATH = "$.intervention.location.type"
    V3_TO_V2_LOCATION_TYPE_MAPPING = {
        "L01.01.05": "L01.01.00",  # Map new location subtype to parent
        "L01.02.13": "L01.02.00",  # Map new location subtype to parent
        "L01.02.14": "L01.02.00",  # Balcon/terrasse → Lieu d'habitation collectif
        "L01.03.04": "L01.03.00",  # Map new location subtype to parent
        "L01.03.05": "L01.03.00",  # Map new location subtype to parent
        "L01.03.06": "L01.03.00",  # Map new location subtype to parent
        "L02.01.01": "L02.01.00",  # Tunnel → Voie publique hors voie rapide
        "L02.01.02": "L02.01.00",  # Piste cyclable → Voie publique hors voie rapide
        "L02.01.03": "L02.01.00",  # Pont/viaduc → Voie publique hors voie rapide
        "L02.02.06": "L02.02.00",  # Map new location subtype to parent
        "L02.03.04": "L02.03.00",  # Map new location subtype to parent
        "L02.03.05": "L02.03.00",  # Map new location subtype to parent
        "L02.04.01": "L02.04.00",  # Map new location subtype to parent
        "L02.04.02": "L02.04.00",  # Map new location subtype to parent
        "L02.06.09": "L02.06.00",  # Map new location subtype to parent
        "L02.06.10": "L02.06.00",  # Map new location subtype to parent
        "L02.07.04": "L02.07.00",  # Map new location subtype to parent
        "L02.07.05": "L02.07.00",  # Map new location subtype to parent
        "L02.07.06": "L02.07.00",  # Map new location subtype to parent
        "L02.07.07": "L02.07.00",  # Map new location subtype to parent
        "L02.08.01": "L02.08.00",  # Map new location subtype to parent
        "L02.08.02": "L02.08.00",  # Map new location subtype to parent
        "L02.08.03": "L02.08.00",  # Map new location subtype to parent
        "L02.09.00": "L02.00.00",  # Map new location subtype to parent
        "L02.09.01": "L02.09.00",  # Map new location subtype to parent
        "L02.09.02": "L02.09.00",  # Map new location subtype to parent
        "L03.02.01": "L03.02.00",  # Map new location subtype to parent
        "L03.02.02": "L03.02.00",  # Map new location subtype to parent
        "L04.06.06": "L04.06.00",  # Map new V3 location code to parent category in V2
        "L04.07.04": "L04.07.00",  # Map new location subtype to parent
        "L04.07.05": "L04.07.00",  # Map new location subtype to parent
        "L04.07.06": "L04.07.00",  # Map new location subtype to parent
        "L04.09.03": "L04.09.00",  # Map new location subtype to parent
        "L04.11.05": "L04.11.00",  # Map new location subtype to parent
        "L04.13.05": "L04.13.00",  # Map new location subtype to parent
        "L05.01.04": "L05.01.00",  # Map new location subtype to parent
        "L05.01.05": "L05.01.00",  # Map new location subtype to parent
        "L05.03.03": "L05.03.00",  # Map new location subtype to parent
        "L05.03.04": "L05.03.00",  # Map new location subtype to parent
        "L05.03.05": "L05.03.00",  # Map new location subtype to parent
        "L05.04.07": "L05.04.00",  # Map new location subtype to parent
        "L06.01.09": "L06.01.00",  # Map new location subtype to parent
        "L06.01.10": "L06.01.00",  # Map new location subtype to parent
        "L06.02.01": "L06.02.00",  # Map new location subtype to parent
        "L06.02.02": "L06.02.00",  # Map new location subtype to parent
        "L06.02.03": "L06.02.00",  # Map new location subtype to parent
        "L06.02.04": "L06.02.00",  # Map new location subtype to parent
        "L06.02.05": "L06.02.00",  # Map new location subtype to parent
        "L06.02.06": "L06.02.00",  # Map new location subtype to parent
        "L06.02.07": "L06.02.00",  # Map new location subtype to parent
        "L06.02.08": "L06.02.00",  # Map new location subtype to parent
        "L06.02.09": "L06.02.00",  # Map new location subtype to parent
        "L06.06.05": "L06.06.00",  # Map new location subtype to parent
        "L06.08.00": "L06.00.00",  # Map new location subtype to parent
        "L06.09.00": "L06.00.00",  # Map new location subtype to parent
        "L06.09.01": "L06.09.00",  # Map new location subtype to parent
        "L06.09.02": "L06.09.00",  # Map new location subtype to parent
        "L06.09.03": "L06.09.00",  # Map new location subtype to parent
        "L06.10.00": "L06.00.00",  # Map new location subtype to parent
    }
