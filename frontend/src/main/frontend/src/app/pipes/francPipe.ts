import { Pipe, PipeTransform } from '@angular/core';
@Pipe({name: 'franc'})
export class FrancPipe implements PipeTransform {
  transform(value: number): string {
    return value + ' f';
  }
}
