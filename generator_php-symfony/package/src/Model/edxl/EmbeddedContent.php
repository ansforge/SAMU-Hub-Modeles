<?php

namespace App\Model\edxl;

class EmbeddedContent
{
    // @Assert\NotNull
    // @JMS\Type("App\Model\Edxl\ContentMessage")
    private ?ContentMessage $message = null;

    public function __construct(?ContentMessage $msg = null)
    {
        $this->message = $msg;
    }

    public function getMessage(): ?ContentMessage { return $this->message; }
    public function setMessage(ContentMessage $msg): void { $this->message = $msg; }

    public function __toString(): string
    {
        return sprintf("EmbeddedContent{message=%s}", $this->message ? $this->message->__toString() : 'null');
    }
}