<?php

/**
 * Copyright © 2023-2025 Agence du Numerique en Sante (ANS)
 * Licensed under the Apache License, Version 2.0
 */

namespace App\Model\edxl;

// use JMS\Serializer\Annotation as JMS;
// use Symfony\Component\Validator\Constraints as Assert;

enum DistributionStatus: string
{
    case ACTUAL = 'Actual';
    case EXERCISE = 'Exercise';

    // /**
    //  * @Assert\NotBlank
    //  * @JMS\SerializedName("distributionStatus")
    //  * @JMS\Type("string")
    //  */

    public function getValue(): string
    {
        return $this->value;
    }

    public static function fromValue(string $value): self
    {
        foreach (self::cases() as $case) {
            if ($case->value === $value) {
                return $case;
            }
        }

        throw new \InvalidArgumentException("Unexpected value '$value'");
    }

    public function __toString(): string
    {
        return $this->value;
    }
}
