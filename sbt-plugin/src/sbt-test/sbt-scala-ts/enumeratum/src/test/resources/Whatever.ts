// Generated by ScalaTS 0.5.8-SNAPSHOT: https://scala-ts.github.io/scala-ts/

export interface Whatever {
  word: string;
}

export function isWhatever(v: any): v is Whatever {
  return (
    ((typeof v['word']) === 'string')
  );
}
