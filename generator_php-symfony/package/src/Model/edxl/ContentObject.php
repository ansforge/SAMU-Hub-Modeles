<?php

namespace App\Model\edxl;

class ContentObject
{
    /**
     * @var ContentWrapper
     *
     * // @JMS\Type("App\Model\edxl\ContentWrapper")
     * // @JMS\SerializedName("jsonContent")
     * // @Assert\NotNull
     */
    private ?ContentWrapper $contentWrapper = null;

    public function __construct(?ContentWrapper $contentWrapper = null)
    {
        $this->contentWrapper = $contentWrapper;
    }

    public function getContentWrapper(): ?ContentWrapper
    {
        return $this->contentWrapper;
    }

    public function setContentWrapper(?ContentWrapper $contentWrapper): void
    {
        $this->contentWrapper = $contentWrapper;
    }

    public function __toString(): string
    {
        return sprintf(
            "ContentObject{jsonContent=%s}",
            $this->contentWrapper ? $this->contentWrapper->__toString() : 'null'
        );
    }
}
