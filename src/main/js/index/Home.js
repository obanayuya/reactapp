"use strict"

import React, { Component } from 'react';
import NewPoster from "../Component/NewPoster";

export default class Home extends Component{


	constructor(props){
		super(props);
	}


	render(){
		return(
		<div style={{backgroundColor:"red"}}>
			Home.js
			<NewPoster/>

		</div>
		)


	}



}



