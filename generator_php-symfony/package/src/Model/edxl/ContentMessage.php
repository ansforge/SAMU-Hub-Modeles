<?php

namespace App\Model\edxl;

use Symfony\Component\Serializer\Annotation\DiscriminatorMap;

#[DiscriminatorMap(typeProperty: null, mapping: [
    'ReferenceWrapper'              => \App\Model\reference\ReferenceWrapper::class,
    'CreateCaseWrapper'             => \App\Model\cisu\CreateCaseWrapper::class,
    'CreateCaseHealthWrapper'       => \App\Model\health\CreateCaseHealthWrapper::class,
    'CreateCaseHealthUpdateWrapper' => \App\Model\health\CreateCaseHealthUpdateWrapper::class,
    'EmsiWrapper'                   => \App\Model\emsi\EmsiWrapper::class,
    'ResourcesInfoWrapper'          => \App\Model\resources\info\ResourcesInfoWrapper::class,
    'ResourcesInfoCisuWrapper'      => \App\Model\cisu\resources\ResourcesInfoCisuWrapper::class,
    'ResourcesEngagementWrapper'    => \App\Model\resources\info\ResourcesEngagementWrapper::class,
    'ResourcesStatusWrapper'        => \App\Model\resources\status\ResourcesStatusWrapper::class,
    'ResourcesRequestWrapper'       => \App\Model\resources\request\ResourcesRequestWrapper::class,
    'ResourcesResponseWrapper'      => \App\Model\resources\response\ResourcesResponseWrapper::class,
    'RpisWrapper'                   => \App\Model\rpis\RpisWrapper::class,
    'InterventionReportWrapper'     => \App\Model\interventionReport\InterventionReportWrapper::class,
    'DocumentLinkWrapper'           => \App\Model\documentLink\DocumentLinkWrapper::class,
    'GeoPositionsUpdateWrapper'     => \App\Model\geo\GeoPositionsUpdateWrapper::class,
    'GeoResourcesRequestWrapper'    => \App\Model\geo\GeoResourcesRequestWrapper::class,
    'GeoResourcesDetailsWrapper'    => \App\Model\geo\GeoResourcesDetailsWrapper::class,
    'AppointmentWrapper'            => \App\Model\sas\AppointmentWrapper::class,
    'TechnicalWrapper'              => \App\Model\technical\TechnicalWrapper::class,
    'TechnicalNoreqWrapper'         => \App\Model\technical\noreq\TechnicalNoreqWrapper::class,
    'ErrorWrapper'                  => \App\Model\report\ErrorWrapper::class,
    'CustomMessage'                 => \App\Model\custom\CustomMessage::class,
])]
abstract class ContentMessage
{
    public function equals(object $other): bool
    {
        return $this === $other || get_class($this) === get_class($other);
    }

    public function hashCode(): int
    {
        return 0;
    }
}
