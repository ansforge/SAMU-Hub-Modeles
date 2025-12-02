<?php

use JMS\Serializer\Annotation as JMS;
use Symfony\Component\Validator\Constraints as Assert;

class Descriptor
{
    /**
     * @Assert\NotBlank
     * @Assert\Type("string")
     * @JMS\Type("string")
     * @JMS\SerializedName("language")
     */
    private ?string $language = null;

    /**
     * @Assert\NotNull
     * @Assert\Valid
     * @JMS\Type("ExplicitAddress")
     * @JMS\SerializedName("explicitAddress")
     */
    private ?ExplicitAddress $explicitAddress = null;

    public function __construct(?string $language = null, ?ExplicitAddress $explicitAddress = null)
    {
        $this->language = $language;
        $this->explicitAddress = $explicitAddress;
    }

    public function getXmlnsType(): string
    {
        return $this->xmlnsType;
    }

    public function getLanguage(): ?string
    {
        return $this->language;
    }

    public function setLanguage(string $language): void
    {
        $this->language = $language;
    }

    public function getExplicitAddress(): ?ExplicitAddress
    {
        return $this->explicitAddress;
    }

    public function setExplicitAddress(ExplicitAddress $explicitAddress): void
    {
        $this->explicitAddress = $explicitAddress;
    }

    public function __toString(): string
    {
        return sprintf(
            "Descriptor{language='%s', explicitAddress=%s}",
            $this->language,
            $this->explicitAddress
        );
    }
}
