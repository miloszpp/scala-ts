// Generated by ScalaTS 0.5.7-SNAPSHOT: https://scala-ts.github.io/scala-ts/
import * as idtlt from 'idonttrustlikethat';

import * as nsFeature from './Feature';

// Validator for InterfaceDeclaration NamedFeature
export const idtltNamedFeature = idtlt.object({
  feature: nsFeature.idtltFeature,
  name: idtlt.string,
});

// Deriving TypeScript type from NamedFeature validator
export type NamedFeature = typeof idtltNamedFeature.T;

export const idtltDiscriminatedNamedFeature = idtlt.intersection(
  idtltNamedFeature,
  idtlt.object({
    _type: idtlt.literal('NamedFeature')
  })
);

// Deriving TypeScript type from idtltDiscriminatedNamedFeature validator
export type DiscriminatedNamedFeature = typeof idtltDiscriminatedNamedFeature.T;

export const discriminatedNamedFeature: (_: NamedFeature) => DiscriminatedNamedFeature = (v: NamedFeature) => ({ _type: 'NamedFeature', ...v });