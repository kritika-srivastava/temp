import { Pipe, PipeTransform } from '@angular/core';
import { Contact } from '../models/Contact';
@Pipe({
  name: 'search'
})

// Implement logic to filter the given contacts based on given searchText
// Convert text to lowercase
export class SearchPipe implements PipeTransform {

  transform(contacts: any, searchText: any): any {
    if (Array.isArray(contacts)) {
      return contacts.filter(function (obj?: Contact) {
        return obj.name.includes(searchText) || obj.mobile.toString().includes(searchText);
      });
    }

  }
}
