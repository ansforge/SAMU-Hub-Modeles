<?php

namespace App\Model\edxl;

class ContentWrapper
{
    /**
     * // @JMS\Type("App\Model\edxl\EmbeddedContent")
     * // @JMS\SerializedName("embeddedJsonContent")
     * // @Assert\NotNull
     */
    private ?EmbeddedContent $embeddedContent = null;

    public function __construct(?EmbeddedContent $embeddedContent = null)
    {
        $this->embeddedContent = $embeddedContent;
    }

    public function getEmbeddedContent(): ?EmbeddedContent
    {
        return $this->embeddedContent;
    }

    public function setEmbeddedContent(?EmbeddedContent $embeddedContent): void
    {
        $this->embeddedContent = $embeddedContent;
    }

    public function __toString(): string
    {
        return sprintf(
            "ContentWrapper{embeddedContent=%s}",
            $this->embeddedContent ? $this->embeddedContent->__toString() : 'null'
        );
    }
}
