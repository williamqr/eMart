import {ProductInfo} from "./productInfo";

export class ProductInOrder {
    productId: string;
    productName: string;
    productPrice: number;
    productStock: number;
    productDescription: string;
    productIcon: string;
    count: number;

    constructor(productInfo:ProductInfo, quantity = 1){
        this.productId = productInfo.productId;
        this.productName = productInfo.name;
        this.productPrice = productInfo.price;
        this.productStock = productInfo.stock;
        this.productDescription = productInfo.description;;
        this.productIcon = productInfo.photo;
        this.count = quantity;
    }

}