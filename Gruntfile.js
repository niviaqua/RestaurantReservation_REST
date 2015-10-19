module.exports = function (grunt) {
	grunt.initConfig({
		pkg:grunt.file.readJSON('package.json'),
	
	cssmin: {
		css: {
			files: {
				'dist/min/app.style.min.css':['WebContent/css/main.css']
			}
		}	
	},
	uglify: {
		js: {
			files: {
				'dist/min/app.script.min.js':['WebContent/app/controller/**/*.js', 'WebContent/app/services/**/*.js', 'WebContent/app/routeconfig/**/*.js']
			}
		}	
	},
	autoprefixer: {
		options: {
			browser: ['last 3 version', 'IE8', 'IE9']
		},
		files: {
		src: 'dist/min/app.style.min.css',
		dest: 'dist/min/app.style.min.css'
		}
		}

	});

	
	grunt.loadNpmTasks('grunt-contrib-cssmin');
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-autoprefixer');
	
	grunt.registerTask('default', ['cssmin','uglify','autoprefixer']);
};
