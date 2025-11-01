const API_BASE_URL = "http://localhost:8081/api/product";

export async function saveProduct(userId, product) {
    const response = await fetch(`${API_BASE_URL}?userId=${userId}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(product),
    });

    if (!response.ok) {
        const errorText = await response.text();
        throw new Error(`Failed to save product: ${errorText}`);
    }

    return await response.json();
}

export const getProductsByUser = async (userId) => {
    try {
        const response = await fetch(`${API_BASE_URL}/user/${userId}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        });

        if (!response.ok) {
            throw new Error("Failed to fetch products");
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const deleteProduct = async (productId) => {
  const response = await fetch(`${API_BASE_URL}/${productId}`, {
    method: "DELETE",
  });

  if (!response.ok) {
    throw new Error("Failed to delete product");
  }

  return true;
};
