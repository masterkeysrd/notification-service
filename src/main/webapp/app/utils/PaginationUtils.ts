import { Pageable } from "../types";

class PaginationUtils {
  static toPaginationParams(pageable: Pageable): string {
    const params = new URLSearchParams();
  
    if (pageable.sort) {
      params.append("sort", pageable.sort);
    }
  
    if (pageable.page) {
      params.append("page", pageable.page.toString());
    }
  
    if (pageable.size) {
      params.append("size", pageable.size.toString());
    }
    return params.toString();
  }
}

export default PaginationUtils;
