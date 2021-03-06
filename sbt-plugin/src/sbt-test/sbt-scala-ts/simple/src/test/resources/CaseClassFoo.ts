// Generated by ScalaTS 0.5.7-SNAPSHOT: https://scala-ts.github.io/scala-ts/

import { CaseClassBar, isCaseClassBar } from './CaseClassBar';

export interface CaseClassFoo {
  id: string;
  name: string;
  i: number;
  flag: number;
  score: number;
  time: number;
  localDate: Date;
  instant: Date;
  localDateTime: Date;
  offsetDateTime: Date;
  zonedDateTime: Date;
  ts: Date;
  tuple2: [string, number];
  tuple3: [Date, Date, CaseClassFoo];
  bar?: CaseClassBar;
}

export function isCaseClassFoo(v: any): v is CaseClassFoo {
  return (
    (!v['bar'] || (v['bar'] && isCaseClassBar(v['bar']))) &&
    (Array.isArray(v['tuple3']) && v['tuple3'].length == 3 && (v['tuple3'][0] && (v['tuple3'][0] instanceof Date)) && (v['tuple3'][1] && (v['tuple3'][1] instanceof Date)) && (v['tuple3'][2] && isCaseClassFoo(v['tuple3'][2]))) &&
    (Array.isArray(v['tuple2']) && v['tuple2'].length == 2 && ((typeof v['tuple2'][0]) === 'string') && ((typeof v['tuple2'][1]) === 'number')) &&
    (v['ts'] && (v['ts'] instanceof Date)) &&
    (v['zonedDateTime'] && (v['zonedDateTime'] instanceof Date)) &&
    (v['offsetDateTime'] && (v['offsetDateTime'] instanceof Date)) &&
    (v['localDateTime'] && (v['localDateTime'] instanceof Date)) &&
    (v['instant'] && (v['instant'] instanceof Date)) &&
    (v['localDate'] && (v['localDate'] instanceof Date)) &&
    ((typeof v['time']) === 'number') &&
    ((typeof v['score']) === 'number') &&
    ((typeof v['flag']) === 'number') &&
    ((typeof v['i']) === 'number') &&
    ((typeof v['name']) === 'string') &&
    ((typeof v['id']) === 'string')
  );
}
