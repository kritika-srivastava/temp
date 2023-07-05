import React from 'react'
import { Card, Button } from 'react-bootstrap';
export default function Cards(props) {

  return (
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src={props.urlToImage} />
      <Card.Body>
        <Card.Title>{props.author}</Card.Title>
        <Card.Text>
          {props.title}
        </Card.Text>

        <Button variant="success" onClick={saveDatatoDb} >Read Later</Button>
      </Card.Body>
    </Card >)


}
function saveDatatoDb() {
  // console.log(props);
}
