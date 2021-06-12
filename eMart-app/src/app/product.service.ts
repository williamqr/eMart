import { Product } from './product';

@Injectable({
  providedIn: 'root'
})

export class ProductService {
  private apiServiceUrl = '';
  constructor(private http: HttpClient) { }
  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('${this.apiServiceUrl}/product');
  }
}
