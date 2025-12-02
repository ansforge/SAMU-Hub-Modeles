<?php

namespace App\Model\edxl;

use DateTimeInterface;
use JMS\Serializer\Annotation as JMS;
use Symfony\Component\Validator\Constraints as Assert;

class EdxlMessage
{
    /**
     * @Assert\NotBlank
     * @JMS\Type("string")
     * @JMS\SerializedName("distributionID")
     */
    private ?string $distributionID = null;

    /**
     * @Assert\NotBlank
     * @JMS\Type("string")
     * @JMS\SerializedName("senderID")
     */
    private ?string $senderID = null;

    /**
     * @Assert\NotNull
     * @Assert\Type("\DateTimeInterface")
     * @JMS\Type("DateTimeImmutable<'Y-m-d\TH:i:sP'>")
     * @JMS\SerializedName("dateTimeSent")
     */
    private ?DateTimeInterface $dateTimeSent = null;

    /**
     * @Assert\NotNull
     * @Assert\Type("\DateTimeInterface")
     * @JMS\Type("DateTimeImmutable<'Y-m-d\TH:i:sP'>")
     * @JMS\SerializedName("dateTimeExpires")
     */
    private ?DateTimeInterface $dateTimeExpires = null;

    /**
     * @Assert\NotBlank
     * @JMS\Type("string")
     * @JMS\SerializedName("distributionStatus")
     */
    private ?DistributionStatus $distributionStatus = null;

    /**
     * @Assert\NotBlank
     * @JMS\Type("string")
     * @JMS\SerializedName("distributionKind")
     */
    private ?DistributionKind $distributionKind = null;

    /**
     * @Assert\NotNull
     * @JMS\Type("App\Model\Edxl\Descriptor")
     */
    private $descriptor;

    /**
     * @Assert\Valid
     * @Assert\Count(min=1)
     *
     * @JMS\Type("array<App\Model\Edxl\ContentObject>")
     * @JMS\XmlList(entry="contentObject", inline=false)
     * @JMS\SerializedName("content")
     */
    private array $content = [];

    public function __construct(
        ?string $distributionID = null,
        ?string $senderID = null,
        ?DateTimeInterface $dateTimeSent = null,
        ?DateTimeInterface $dateTimeExpires = null,
        ?DistributionStatus $distributionStatus = null,
        ?DistributionKind $distributionKind = null,
        $descriptor = null
    ) {
        $this->distributionID = $distributionID;
        $this->senderID = $senderID;
        $this->dateTimeSent = $dateTimeSent;
        $this->dateTimeExpires = $dateTimeExpires;
        $this->distributionStatus = $distributionStatus;
        $this->distributionKind = $distributionKind;
        $this->descriptor = $descriptor;
    }

    public function getDistributionID(): ?string { return $this->distributionID; }
    public function setDistributionID(?string $id): self { $this->distributionID = $id; return $this; }

    public function getSenderID(): ?string { return $this->senderID; }
    public function setSenderID(?string $id): self { $this->senderID = $id; return $this; }

    public function getDateTimeSent(): ?DateTimeInterface { return $this->dateTimeSent; }
    public function setDateTimeSent(?DateTimeInterface $dt): self { $this->dateTimeSent = $dt; return $this; }

    public function getDateTimeExpires(): ?DateTimeInterface { return $this->dateTimeExpires; }
    public function setDateTimeExpires(?DateTimeInterface $dt): self { $this->dateTimeExpires = $dt; return $this; }

    public function getDistributionStatus(): ?DistributionStatus { return $this->distributionStatus; }
    public function setDistributionStatus(?DistributionStatus $s): self { $this->distributionStatus = $s; return $this; }

    public function getDistributionKind(): ?distributionKind { return $this->distributionKind; }
    public function setDistributionKind(?DistributionKind $k): self { $this->distributionKind = $k; return $this; }

    public function getDescriptor() { return $this->descriptor; }
    public function setDescriptor($d): self { $this->descriptor = $d; return $this; }

    // ------------------------------------------------------------
    // Content Management
    // ------------------------------------------------------------

    /** @return ContentObject[] */
    public function getContent(): array
    {
        return $this->content;
    }

    /** @param ContentObject[] $content */
    public function setContent(array $content): self
    {
        $this->content = $content;
        return $this;
    }

    public function addContentObject(ContentObject $obj): self
    {
        $this->content[] = $obj;
        return $this;
    }

    public function setContentFrom(ContentMessage $message): self
    {
        $this->content = [
            new ContentObject(
                new ContentWrapper(
                    new EmbeddedContent($message)
                )
            )
        ];
        return $this;
    }

    public function getFirstContentMessage(): ContentMessage
    {
        if (empty($this->content)) {
            throw new \RuntimeException("No content items");
        }

        return $this->content[0]
            ->getContentWrapper()
            ->getEmbeddedContent()
            ->getMessage();
    }

    /** @return ContentMessage[] */
    public function getAllContentMessages(): array
    {
        return array_map(
            fn(ContentObject $obj) =>
                $obj->getContentWrapper()->getEmbeddedContent()->getMessage(),
            $this->content
        );
    }
}
