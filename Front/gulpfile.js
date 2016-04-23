var gulp = require('gulp'),
    rollup = require('gulp-rollup'),
    babel = require('gulp-babel'),
    inject = require('gulp-inject'),
    concat = require('gulp-concat'),
    cssConcat = require('gulp-concat-css'),
    minify = require('gulp-uglify'),
    merge = require('merge-stream'),
    series = require('stream-series'),
    sync = require('browser-sync'),
    rollPaths = require('rollup-plugin-includepaths'),
    webpack = require('gulp-webpack'),
    libs = require('./config.libs.js')

gulp.task('js', function() {
    var appLibsJS = gulp.src(libs.js)
        .pipe(concat('libs.js'))
        .pipe(gulp.dest('./dist'))

    var appJS = gulp.src('./app/*.js')
        // .pipe(webpack({
        //     watch: true,
        //     module: {
        //         loaders: [{
        //             test: /\.css$/,
        //             loader: 'style!css'
        //         }, {
        //             test: /\.js$/,
        //             exclude: /node_modules/,
        //             loader: "babel-loader"
        //         }]
        //     }
        // }))
        // .pipe(babel())
        //.pipe(gulp.dest('./dist'))
        .pipe(rollup({
            format: 'cjs',
            plugins: [rollPaths()]
        }))
        .pipe(babel())
        .pipe(gulp.dest('./dist'))



    var appLibsCSS = gulp.src(libs.css);
    var appCSS = gulp.src('./app/*.css');
    var mergeCSS = merge(appLibsCSS, appCSS)
        .pipe(cssConcat('app.css'))
        .pipe(gulp.dest('./dist'))

    var images = gulp.src('assets/**')
        .pipe(gulp.dest('./dist'))

    return gulp.src('index.html')
        .pipe(inject(series(appLibsJS, appJS), {
            ignorePath: 'dist',
            name: 'bundle',
            relative: true
        }))
        .pipe(inject(mergeCSS, {
            ignorePath: 'dist',
            relative: true
        }))
        .pipe(gulp.dest('./dist'))
})

gulp.task('server', function() {
    sync({
        server: './dist'
    })
})
gulp.task('watch', function() {

    gulp.watch(['app/**/*.js'], ['js']).on('change', sync.reload)
    gulp.watch('./index.html', ['js']).on('change', sync.reload)

    gulp.watch(['app/**/*.css'], ['js']).on('change', sync.reload)
})

gulp.task('default', ['js', 'server', 'watch'], function() {

})
