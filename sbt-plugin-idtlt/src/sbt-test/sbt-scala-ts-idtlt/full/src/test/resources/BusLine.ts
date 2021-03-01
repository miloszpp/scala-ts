// Generated by ScalaTS 0.5.6-SNAPSHOT: https://scala-ts.github.io/scala-ts/
import * as idtlt from 'idonttrustlikethat';

// Validator for InterfaceDeclaration BusLine
export const idtltBusLine = idtlt.object({
  stopIds: idtlt.array(idtlt.string),
  name: idtlt.string,
  id: idtlt.number,
});

// Super-type declaration Transport is ignored

// Deriving TypeScript type from BusLine validator
export type BusLine = typeof idtltBusLine.T;

export const idtltDiscriminatedBusLine = idtlt.intersection(
  idtltBusLine,
  idtlt.object({
    _type: idtlt.literal('BusLine')
  })
);

// Deriving TypeScript type from idtltDiscriminatedBusLine validator
export type DiscriminatedBusLine = typeof idtltDiscriminatedBusLine.T;

export const discriminatedBusLine: (_: BusLine) => DiscriminatedBusLine = (v: BusLine) => ({ _type: 'BusLine', ...v });
