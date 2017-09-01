export class Livre {
  name: string;
  quantity: number;
   price: number;
 author: string;
 edition: string;
 bookFile: string;
  constructor(name: string = '', quantity: number = 0, price: number = 0, author: string, edition: string, bookFile: string) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.author = author;
    this.edition = edition;
    this.bookFile = bookFile;
  }

}
