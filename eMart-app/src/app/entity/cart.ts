import {ProductInOrder} from "./productInOrder";


export class Cart {
    cartId: number;
    products: ProductInOrder[];

    constructor() {
        this.cartId = 0;
        this.products = [];
    }
}

