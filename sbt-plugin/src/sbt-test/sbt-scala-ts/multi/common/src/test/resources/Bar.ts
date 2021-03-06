// Generated by ScalaTS 0.5.7-SNAPSHOT: https://scala-ts.github.io/scala-ts/

import { Feature, isFeature } from './Feature';

export class Bar implements Feature {
  private static instance: Bar;

  private constructor() {}

  public static getInstance() {
    if (!Bar.instance) {
      Bar.instance = new Bar();
    }

    return Bar.instance;
  }
}

export function isBar(v: any): v is Bar {
  return (v instanceof Bar) && (v === Bar.getInstance());
}
