// Generated by ScalaTS 0.5.8-SNAPSHOT: https://scala-ts.github.io/scala-ts/
import * as idtlt from 'idonttrustlikethat';

// Validator for InterfaceDeclaration Whatever
export const idtltWhatever = idtlt.object({
  word: idtlt.string,
});

// Super-type declaration Greeting is ignored

// Deriving TypeScript type from Whatever validator
export type Whatever = typeof idtltWhatever.T;

export const idtltDiscriminatedWhatever = idtlt.intersection(
  idtltWhatever,
  idtlt.object({
    _type: idtlt.literal('Whatever')
  })
);

// Deriving TypeScript type from idtltDiscriminatedWhatever validator
export type DiscriminatedWhatever = typeof idtltDiscriminatedWhatever.T;

export const discriminatedWhatever: (_: Whatever) => DiscriminatedWhatever = (v: Whatever) => ({ _type: 'Whatever', ...v });

export function isWhatever(v: any): v is Whatever {
  return (
    ((typeof v['word']) === 'string')
  );
}