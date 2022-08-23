import { ThrowStmt } from "@angular/compiler";
import {ProductInOrder} from "./productInOrder";

export class ProductInfo {
    productId: string;
    name: string;
    price: number;
    stock: number;
    description: string;
    photo: string;
    productStatus: number; // 0: onsale 1: offsale
    createTime: string;
    updateTime: string;


    constructor(productInOrder?: ProductInOrder) {
        if (productInOrder) {
            this.productId = productInOrder.productId;
            this.name = productInOrder.productName;
            this.price = productInOrder.productPrice;
            this.stock = productInOrder.productStock;
            this.description = productInOrder.productDescription;
            this.photo = productInOrder.productIcon;
            this.productStatus = 0;
        } else {
            this.productId = '';
            this.name = '';
            this.price = 20;
            this.stock = 100;
            this.description = '';
            this.photo = '';
            this.productStatus = 0;
        }
        this.createTime = '';
        this.updateTime = '';
    }
}