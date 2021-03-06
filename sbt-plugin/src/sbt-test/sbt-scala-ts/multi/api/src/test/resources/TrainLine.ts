// Generated by ScalaTS 0.5.7-SNAPSHOT: https://scala-ts.github.io/scala-ts/

import { NamedFeature, isNamedFeature } from './NamedFeature';
import { Transport, isTransport } from './Transport';

export interface TrainLine extends Transport {
  name: string;
  startStationId: string;
  endStationId: string;
  feature: NamedFeature;
}

export function isTrainLine(v: any): v is TrainLine {
  return (
    (v['feature'] && isNamedFeature(v['feature'])) &&
    ((typeof v['endStationId']) === 'string') &&
    ((typeof v['startStationId']) === 'string') &&
    ((typeof v['name']) === 'string')
  );
}