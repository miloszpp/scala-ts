// Generated by ScalaTS 0.5.7-SNAPSHOT: https://scala-ts.github.io/scala-ts/

import type { Transport } from './Transport';

export interface TrainLine extends Transport {
  name: string;
  startStationId: string;
  endStationId: string;
}
