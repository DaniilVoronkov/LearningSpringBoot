import {render} from "@testing-library/react";
import ProductForm from "../components/ProductForm";

beforeAll(async () => {

    jest.spyOn(global,
        "fetch").mockImplementation(() => {
        Promise.resolve({
            json: {
                id: 1,
                productName: "test",
                productPrice: 123.12,
                productType: "In Packages"
            }
        })
    })
})


test('', () => {
    const result = render(<ProductForm />);
})