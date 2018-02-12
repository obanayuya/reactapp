"use strict";


import Home from "./index/Home";
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import React, { Component } from 'react';
import ReactDOM from "react-dom";
import UserRegister from "./index/UserRegister";


export class App extends Component {

	constructor(props){
		super(props);
	}


render(){

	//URLのパスを取得
	let path = location.pathname;
	path = path.split("/")[2];
	console.log(path);

	//URLのパス　localhost;8080/index/\\\
	//↑\\\の部分を取得　\\\によってページを振り分ける
	let Component ;
	if(path=="home"){
		Component = <Home/>;
	}else if(path=="UserRegister"){
		Component = <UserRegister/>;
	}




	return (
			<MuiThemeProvider>
			<div>
				App.js
				{Component}
			</div>
			</MuiThemeProvider>
			);


}

};

console.log("app.js　読み込み成功しました！yattane")

ReactDOM.render(<App/>,document.getElementById("react"));



