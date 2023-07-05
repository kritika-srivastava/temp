import React, { useState, useEffect } from 'react'
import { Button, ButtonGroup, ButtonToolbar, CardGroup, Dropdown, DropdownButton, Row } from 'react-bootstrap'
import axios from 'axios';
import Cards from './Cards';

export default function Dashboard() {


  const [news, setnews] = useState([])

  useEffect(() => console.log(news), [news])

  function settingUrlCategory(e) {

    axios.get(`https://newsapi.org/v2/top-headlines?category=${e}&apikey=3a4efe6c65bf4a86892fd270ea44d17b&page=1/`)
      .then(res => {
        setnews(res.data.articles);
        //console.log(res.data.articles);
      })

  }

  function trendingNews() {
    axios.get(`https://newsapi.org/v2/top-headlines?country=in&apikey=3a4efe6c65bf4a86892fd270ea44d17b&page=1/`)
      .then(res => {
        setnews(res.data.articles);
        //console.log(res.data.articles);
      })
  }

  return (
    <>
      <ButtonToolbar aria-label="Toolbar with button groups">
        <ButtonGroup  className="me-2" aria-label="Basic example">
          <DropdownButton onSelect={(e) => settingUrlCategory(e)} title="News Categories" variant="danger">

            <Dropdown.Item eventKey='business' >business</Dropdown.Item>
            <Dropdown.Item eventKey='entertainment'>entertainment</Dropdown.Item>
            <Dropdown.Item eventKey='general'>general</Dropdown.Item>
            <Dropdown.Item eventKey='health' >health</Dropdown.Item>
            <Dropdown.Item eventKey='sciences' >sciences</Dropdown.Item>
            <Dropdown.Item eventKey='ports' >ports</Dropdown.Item>
            <Dropdown.Item eventKey='technology' >technology</Dropdown.Item>

          </DropdownButton >
        </ButtonGroup>
        <ButtonGroup className="me-2">
          <Button onClick={() => trendingNews()} variant="success" >Trending News</Button>
        </ButtonGroup>
      </ButtonToolbar>
      <>
        &nbsp;

        &nbsp;

        <div>
          <CardGroup>
            <Row xs={1} md={2} className="g-4">
              {news.map((article, i) => <Cards key={i} author={article.author} urlToImage={article.urlToImage} title={article.title} />)}
            </Row>
          </CardGroup>
        </div>
      </>
    </>
  )

}
