import { ThrowStmt } from "@angular/compiler";
import {ProductInfo} from "./productInfo";

export class Item {
    quantity: number;
    productInfo: ProductInfo

    constructor() {
        this.quantity = 0;
        this.productInfo = new ProductInfo;
    }

}