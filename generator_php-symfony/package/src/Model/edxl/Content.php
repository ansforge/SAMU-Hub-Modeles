<?php

namespace App\Model\edxl;

class Content
{
    /**
     * @var ContentObject
     *
     * // @JMS\Type("App\Model\edxl\ContentObject")
     * // @JMS\SerializedName("contentObject")
     * // @Assert\NotNull
     */
    private ?ContentObject $contentObject = null;

    public function __construct(?ContentObject $contentObject = null)
    {
        $this->contentObject = $contentObject;
    }

    public function getContentObject(): ?ContentObject
    {
        return $this->contentObject;
    }

    public function setContentObject(?ContentObject $contentObject): void
    {
        $this->contentObject = $contentObject;
    }

    public function __toString(): string
    {
        return sprintf(
            "Content{contentObject=%s}",
            $this->contentObject ? $this->contentObject->__toString() : 'null'
        );
    }
}
