fn = function () {
    header.css({
        'opacity': '0.5'
    });
};
jQuery(function ($) {
        var doc = $(document),
            header = $('.navbar-default');
        doc.on('scroll', function () {

            if (doc.scrollTop() > 65) {
                header.css({
                    'top': '-30px',
                    'height': '100px',
                    'opacity': '0.5'
                });
            } else {
                header.css({
                    'top': '0px',
                    'height': 'auto',
                    'opacity': '1'
                });

            }

            if (doc.scrollTop() > 65) {
                header.on('hover', function () {
                    header.css({
                        'opacity': '1'
                    });
                })
                header.mouseleave(fn);
            }
            else {
                header.unbind("mouseleave",fn)
            }
        });
    }
)
;