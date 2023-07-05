import { Button } from 'react-bootstrap'
import React, { useState } from 'react'
import { Form } from 'react-bootstrap'
export default function AddProduct({ addProduct }) {

    const [inputs, setInputs] = useState({});


    function handleProductNameChange(e) {
        const name = e.target.name;
        const value = e.target.value;
        setInputs(values => ({ ...values, [name]: value }))
    }

    function handleBrandChange(e) {
        const brand = e.target.name;
        const value = e.target.value;
        setInputs(values => ({ ...values, [brand]: value }))
    }

    function handleQuantityChange(e) {
        const quantity = e.target.name;
        const value = e.target.value;
        setInputs(values => ({ ...values, [quantity]: value }))
    }

    function handlePriceChange(e) {
        const price = e.target.name;
        const value = e.target.value;
        setInputs(values => ({ ...values, [price]: value }))
    }

    function handleFormSubmit(e) {
        e.preventDefault();
        e.target.reset();
        //console.log(inputs);
        //postData(inputs);


    }

    return (
        <>
        &nbsp;

        &nbsp;


            <div className="container">

                <Form onSubmit={handleFormSubmit}>
                    <Form.Group>
                        <Form.Control name="name" onChange={(e) => handleProductNameChange(e)} placeholder="Product Name" required />
                    </Form.Group>
                    &nbsp;

                    <Form.Group>
                        <Form.Control name="brand" onChange={(e) => handleBrandChange(e)} placeholder="Brand" required />
                    </Form.Group>
                    &nbsp;

                    <Form.Group>
                        <Form.Control type="number" name="quantity" onChange={(e) => handleQuantityChange(e)} placeholder="Quantity" required />
                    </Form.Group>
                    &nbsp;

                    <Form.Group>
                        <Form.Control type="number" name="price" onChange={(e) => handlePriceChange(e)} placeholder="Price" required />
                    </Form.Group>
                    &nbsp;

                    <Button variant="primary" type="submit" onClick={(e) => addProduct(e, inputs)}>Submit</Button>
                </Form>


            </div>
        </>
    )
}
