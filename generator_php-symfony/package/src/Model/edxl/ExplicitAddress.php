<?php

use JMS\Serializer\Annotation as JMS;
use Symfony\Component\Validator\Constraints as Assert;

class ExplicitAddress
{
    /**
     * @Assert\NotBlank
     * @Assert\Type("string")
     * @JMS\Type("string")
     * @JMS\SerializedName("explicitAddressScheme")
     */
    private ?string $explicitAddressScheme = null;

    /**
     * @Assert\NotBlank
     * @Assert\Type("string")
     * @JMS\Type("string")
     * @JMS\SerializedName("explicitAddressValue")
     */
    private ?string $explicitAddressValue = null;

    public function __construct(?string $scheme = null, ?string $value = null)
    {
        $this->explicitAddressScheme = $scheme;
        $this->explicitAddressValue = $value;
    }

    public function getExplicitAddressScheme(): ?string
    {
        return $this->explicitAddressScheme;
    }

    public function setExplicitAddressScheme(string $scheme): void
    {
        $this->explicitAddressScheme = $scheme;
    }

    public function getExplicitAddressValue(): ?string
    {
        return $this->explicitAddressValue;
    }

    public function setExplicitAddressValue(string $value): void
    {
        $this->explicitAddressValue = $value;
    }

    public function __toString(): string
    {
        return sprintf(
            "ExplicitAddress{explicitAddressScheme='%s', explicitAddressValue='%s'}",
            $this->explicitAddressScheme,
            $this->explicitAddressValue
        );
    }
}
