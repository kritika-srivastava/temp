import React from 'react'
import { Button } from 'react-bootstrap';

export default function ProductsData({ products, handleDelete }) {



    return (
        <div>
            <table className="table" >
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ProductName</th>
                        <th scope="col">Brand</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map((data) => {

                            return (
                                <tr key={data.id}>
                                    <td>{data.id}</td>
                                    <td>{data.name}</td>
                                    <td>{data.brand}</td>
                                    <td>{data.quantity}</td>
                                    <td>{data.price}</td>
                                    <td><Button variant='danger' onClickCapture={(e) => handleDelete(e, data.id)}>Delete</Button></td>
                                </tr>)

                        })
                    }
                </tbody>
            </table>
        </div>
    )
}
