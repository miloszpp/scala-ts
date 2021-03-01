// Generated by ScalaTS 0.5.6-SNAPSHOT: https://scala-ts.github.io/scala-ts/
import * as idtlt from 'idonttrustlikethat';

// Validator for InterfaceDeclaration TrainLine
export const idtltTrainLine = idtlt.object({
  endStationId: idtlt.string,
  startStationId: idtlt.string,
  name: idtlt.string,
});

// Super-type declaration Transport is ignored

// Deriving TypeScript type from TrainLine validator
export type TrainLine = typeof idtltTrainLine.T;

export const idtltDiscriminatedTrainLine = idtlt.intersection(
  idtltTrainLine,
  idtlt.object({
    _type: idtlt.literal('TrainLine')
  })
);

// Deriving TypeScript type from idtltDiscriminatedTrainLine validator
export type DiscriminatedTrainLine = typeof idtltDiscriminatedTrainLine.T;

export const discriminatedTrainLine: (_: TrainLine) => DiscriminatedTrainLine = (v: TrainLine) => ({ _type: 'TrainLine', ...v });
