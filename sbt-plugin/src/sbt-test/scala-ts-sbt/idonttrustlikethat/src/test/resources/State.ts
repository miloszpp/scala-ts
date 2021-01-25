// Generated by ScalaTS 0.4.1-SNAPSHOT: https://scala-ts.github.io/scala-ts/
import * as idtlt from 'idonttrustlikethat';

import * as nsAlabama from './Alabama';
import * as nsAlaska from './Alaska';

// Validator for UnionDeclaration State
export const idtltState = idtlt.union(
  nsAlabama.idtltDiscriminatedAlabama,
  nsAlaska.idtltDiscriminatedAlaska);

export const idtltDiscriminatedState = idtlt.intersection(
  idtltState,
  idtlt.object({
    '_type': idtlt.literal('State')
  })
);

// Deriving TypeScript type from State validator
export type State = typeof idtltState.T;
