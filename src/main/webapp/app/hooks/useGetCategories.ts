import { useState } from "react";
import { Category } from "../types";
import CategoryService from "../services/CategoryService";

function useGetCategories() {
    const [loading, setLoading] = useState(false);
    const [categories, setCategories] = useState<Category[]>([]);
  
    const getCategories = async () => {
      setLoading(true);
      const response = await CategoryService.getCategories();
      setCategories(response);
      setLoading(false);
    };
  
    return { loading, categories, getCategories };
  }

export default useGetCategories;