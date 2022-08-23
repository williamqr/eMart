export class JwtResponse {
    token: string;
    type: string;
    account: string;
    name: string;
    role: string;

    constructor(){
        this.token="";
        this.type="";
        this.account="";
        this.name="";
        this.role="";
    }
}